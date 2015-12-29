package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpConnection;
import org.junit.Test;


import model.openData.RequestInfo;
import model.openData.StoreZoneDataGetter;
import model.openData.dataForm.StoreZoneDataForm;
import model.openData.templete.DataGetterTemplete;

public class ApiTest {
	//@Test
	public void getStoreZone() throws IOException{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("type", "xml");
		parameters.put("key", "1882");
		parameters.put("numOfRows", "999");
		parameters.put("pageNo", "1");
		
		RequestInfo requestInfo = new RequestInfo("http://apis.data.go.kr/B553077/api/open/sdsc/storeZoneOne",
				parameters, "ServiceKey", "b4%2FOQgFU8EroBosLvjRoPFNiXwHX8W2d8wFrsmJTm1r%2FeiOUcmlWXOzIU1j6%2BjsZgSumHK0TRaf87G%2BH%2BY1oIw%3D%3D");
		DataGetterTemplete templete = new StoreZoneDataGetter();
		List<StoreZoneDataForm> infos = templete.getData(requestInfo);
		for(StoreZoneDataForm dataForm : infos){
			System.out.println(dataForm);
		}
	}
	
	@Test
	public void calendarTest() throws IOException{
		StringBuffer url = new StringBuffer("https://www.googleapis.com/calendar/v3/calendars/janghaeye@gmail.com/events");
		url.append("?" + URLEncoder.encode("key", "UTF-8") + "=AIzaSyAfCwtKwhFhdElxyvYLXweUWCm-9c_sCfw");
		
		URL requestUrl = new URL(url.toString());
		HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		System.out.println("response code : " + conn.getResponseCode());
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300){
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str = "";
			while((str = reader.readLine()) != null){
				System.out.println(str);
			}
			reader.close();
		}else{
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			String str = "";
			while((str = reader.readLine()) != null){
				System.out.println(str);
			}
			reader.close();
		}
	}
}
