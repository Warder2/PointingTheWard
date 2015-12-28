package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import model.openData.RequestInfo;
import model.openData.RequestInfo.RequestMethod;
import model.openData.StoreZoneDataGetter;
import model.openData.dataForm.StoreZoneDataForm;
import model.openData.templete.DataGetterTemplete;

public class ApiTest {
	@Test
	public void getStoreZone() throws IOException{
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("type", "xml");
		parameters.put("key", "1882");
		parameters.put("numOfRows", "999");
		parameters.put("pageNo", "1");
		
		RequestInfo requestInfo = new RequestInfo("http://apis.data.go.kr/B553077/api/open/sdsc/storeZoneOne",
				parameters, "ServiceKey", "b4%2FOQgFU8EroBosLvjRoPFNiXwHX8W2d8wFrsmJTm1r%2FeiOUcmlWXOzIU1j6%2BjsZgSumHK0TRaf87G%2BH%2BY1oIw%3D%3D");
		requestInfo.setRequestMethod(RequestMethod.POST);
		DataGetterTemplete templete = new StoreZoneDataGetter();
		List<StoreZoneDataForm> infos = templete.getData(requestInfo);
		for(StoreZoneDataForm dataForm : infos){
			System.out.println(dataForm);
		}
	}
}
