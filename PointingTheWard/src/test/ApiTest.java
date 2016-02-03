package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import model.beans.Place;
import model.beans.Point;
import model.openData.GoogleDistansMatrixDataGetter;
import model.openData.GoogleGeocodingDataGetter;
import model.openData.RequestInfo;
import model.openData.StoreZoneDataGetter;
import model.openData.dataForm.GoogleDistanceMatrixDataForm;
import model.openData.dataForm.StoreZoneDataForm;
import model.openData.template.DataGetterTemplate;
import model.openDataVO.GoogleGeocoding;
import model.openDataVO.StoreZone;

public class ApiTest {


	public void getStoreZone() throws IOException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("type", "xml");
		parameters.put("key", "1232");
		parameters.put("numOfRows", "999");
		parameters.put("pageNo", "1");

		RequestInfo requestInfo = new RequestInfo("http://apis.data.go.kr/B553077/api/open/sdsc/storeZoneOne",
				parameters, "ServiceKey",
				"b4%2FOQgFU8EroBosLvjRoPFNiXwHX8W2d8wFrsmJTm1r%2FeiOUcmlWXOzIU1j6%2BjsZgSumHK0TRaf87G%2BH%2BY1oIw%3D%3D");

		DataGetterTemplate templete = new StoreZoneDataGetter();
		List<StoreZoneDataForm> infos = templete.getData(requestInfo);
		for (StoreZoneDataForm dataForm : infos) {
			System.out.println(dataForm);
		}
	}
	
	

	public void getGoogle() {
		Map<String, String> parameters = new HashMap<String, String>();
		/*
		parameters.put("origins", "Vancouver BC|역삼역|강남역");
		parameters.put("destinations", "San Francisco|강남역|금정역");
		*/
		parameters.put("origins", "인천광역시 연수구 옥련동 626 럭키송도아파트");
		parameters.put("destinations", "강남역");
		parameters.put("mode", "transit");
		parameters.put("language", "kr-ko");
		RequestInfo requestInfo = new RequestInfo("https://maps.googleapis.com/maps/api/distancematrix/xml", parameters,
				"key", "AIzaSyB11fLFswQhh45Yh2a9UkBmHFIkAuTpniE");
		List<GoogleDistanceMatrixDataForm> result = null;
		DataGetterTemplate templete = new GoogleDistansMatrixDataGetter();
		try {
			result = templete.getData(requestInfo);
			if (result != null) {
				for (GoogleDistanceMatrixDataForm g : result) {
					System.out.println(g.getDurationResult());
				}
			} else {
				System.out.println("결과가 없습니다.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void geocodingPlace() {
		GoogleGeocoding geocoding = null;

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("address", "서울 센트럴시티");
		RequestInfo requestInfo = new RequestInfo("https://maps.googleapis.com/maps/api/geocode/xml", parameters, "key",
				"AIzaSyB11fLFswQhh45Yh2a9UkBmHFIkAuTpniE");
		DataGetterTemplate template = new GoogleGeocodingDataGetter();
		try {
			List<GoogleGeocoding> result = template.getData(requestInfo);
			for (GoogleGeocoding f : result) {
				System.out.println(f);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getGoogleGeocoding() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("address", "시흥시 은행동 대우 4차 푸르지오");
		RequestInfo requestInfo = new RequestInfo("https://maps.googleapis.com/maps/api/geocode/xml", parameters, "key",
				"AIzaSyB11fLFswQhh45Yh2a9UkBmHFIkAuTpniE");
		DataGetterTemplate template = new GoogleGeocodingDataGetter();
		try {
			List<GoogleGeocoding> result = template.getData(requestInfo);
			for (GoogleGeocoding f : result) {
				System.out.println(f);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//127.3795590
	//37.6841320
	@Test
	public void getStreet() throws UnsupportedEncodingException, IOException {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("type", "xml");
		parameters.put("numOfRows", "999");
		parameters.put("radius", "5000");
		parameters.put("cx", "127.004528");
		parameters.put("cy", "37.567538");
		parameters.put("pageNo", "1");

		RequestInfo requestInfo = new RequestInfo("http://apis.data.go.kr/B553077/api/open/sdsc/storeZoneInRadius",
				parameters, "ServiceKey",
				"og2lJU4CeWL4ZEgfp3o%2F17D%2Fj9mbsbSCK4YTwWPF15sGHlakqZEKX8PA%2B6XyAs%2BD0%2FPe24pVucXQckQ%2Fw230tA%3D%3D");

		DataGetterTemplate templete = new StoreZoneDataGetter();
		List<StoreZoneDataForm> infos = templete.getData(requestInfo);

		//for (StoreZoneDataForm dataForm : infos)
		//	System.out.println(dataForm);

		List<StoreZone> szList = new ArrayList<StoreZone>();

		for (StoreZoneDataForm dataForm : infos) {

			dataForm.setCoords(dataForm.getCoords().replace("POLYGON ((", ""));
			dataForm.setCoords(dataForm.getCoords().replace("))", ""));

			StoreZone sz = new StoreZone();

			sz.setCoordNum(Integer.parseInt(dataForm.getCoordNum()));
			sz.setcoordes(dataForm.getCoords());
			sz.setMainTrarNm(dataForm.getMainTrarNm());
			sz.setCtprvnNm((dataForm.getCtprvnNm()));
			sz.setSignguNm(dataForm.getSignguNm());

			szList.add(sz);
		}
		
		for(StoreZone sz : szList)
			System.out.println(sz);
		
	}
}
