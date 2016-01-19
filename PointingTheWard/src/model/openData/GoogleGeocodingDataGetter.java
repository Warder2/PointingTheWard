package model.openData;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.openData.template.DataGetterDOMTemplate;
import model.openDataVO.GoogleGeocoding;

public class GoogleGeocodingDataGetter extends DataGetterDOMTemplate {

	@SuppressWarnings("unchecked")
	@Override
	protected <T> List<T> getData(Element root) {
		if (root.getElementsByTagName("status").item(0).getTextContent().equals("OK")) {
			
			Element locationInfo = (Element) root.getElementsByTagName("result").item(0);
			Element location = (Element) root.getElementsByTagName("location").item(0);
			
			List<GoogleGeocoding> resultGeocoding = new ArrayList<GoogleGeocoding>(); 
			GoogleGeocoding googleGeocodingData = new GoogleGeocoding();
			googleGeocodingData.setAddress(getValue("formatted_address", locationInfo));
			googleGeocodingData.setLatitude(getValue("lat", location));
			googleGeocodingData.setLongitude(getValue("lng", location));
			googleGeocodingData.setGooglePlaceId(getValue("place_id", locationInfo));
			resultGeocoding.add(googleGeocodingData);
			
			return (List<T>) resultGeocoding;
		} else {
			System.out.println("ZERO_RESULTS");
			return null;
		}
	}
}
