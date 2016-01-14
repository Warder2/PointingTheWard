package model.openData;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.openData.dataForm.GoogleDistanceMatrixDataForm;
import model.openData.template.DataGetterDOMTemplate;

public class GoogleDistansMatrixDataGetter extends DataGetterDOMTemplate {

	@SuppressWarnings("unchecked")
	@Override
	protected List<GoogleDistanceMatrixDataForm> getData(Element root) {

		NodeList origin = root.getElementsByTagName("origin_address");
		NodeList destination = root.getElementsByTagName("destination_address");
		NodeList rows = root.getElementsByTagName("row");

		
		if (rows.getLength() != 0) {
			List<GoogleDistanceMatrixDataForm> distanceResult = new ArrayList<GoogleDistanceMatrixDataForm>();
			for (int rowCnt = 0; rowCnt < rows.getLength(); rowCnt++) {

				Element row = (Element) rows.item(rowCnt);
				NodeList elements = row.getElementsByTagName("element");

				for (int elementCnt = 0; elementCnt < elements.getLength(); elementCnt++) {
					
					Element element = (Element) elements.item(elementCnt);
					if (getValue("status", element).trim().toUpperCase().equals("OK")) {

						GoogleDistanceMatrixDataForm distanceData = new GoogleDistanceMatrixDataForm();

						Element duration = (Element) element.getElementsByTagName("duration").item(0);
						Element distance = (Element) element.getElementsByTagName("distance").item(0);
						distanceData.setOrigins(origin.item(rowCnt).getTextContent());
						distanceData.setDestination(destination.item(elementCnt).getTextContent());
						distanceData.setDurationValue(getValue("value", duration));
						distanceData.setDurationResult(getValue("text", duration));
						distanceData.setDistanceValue(getValue("value", distance));
						distanceData.setDistanceResult(getValue("value", distance));
						distanceResult.add(distanceData);
					} else if (getValue("status", element).trim().toUpperCase().equals("ZERO_RESULTS")) {
						//System.out.println("불가능한 경로");
					}
				}
				
			}
			return distanceResult;
		}else{
			return null;
		}
	}
}
