package model.openData;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.openData.dataForm.GoogleDistanceMatrixDataForm;
import model.openData.template.DataGetterDOMTemplate;

public class GoogleDistansMatrixDataGetter extends DataGetterDOMTemplate {
	@Override
	protected <T> List<T> getData(Element root) {

		NodeList origin = root.getElementsByTagName("origin_address");
		NodeList destination = root.getElementsByTagName("destination_address");

		NodeList rows = root.getElementsByTagName("row");
		
		for (int rowCnt = 0; rowCnt < rows.getLength(); rowCnt++) {
			
			Element row = (Element) rows.item(rowCnt);
			NodeList elements = row.getElementsByTagName("element");

			for (int elementCnt = 0; elementCnt < elements.getLength(); elementCnt++) {
				System.out.println(origin.item(rowCnt).getTextContent() +"에서 " + destination.item(elementCnt).getTextContent()+"의 결과");
				
				Element element = (Element) elements.item(elementCnt);
				if (getValue("status", element).trim().toUpperCase().equals("OK")) {
					
					GoogleDistanceMatrixDataForm googleDistanceMatrixDataForm = new GoogleDistanceMatrixDataForm();

					Element duration = (Element) element.getElementsByTagName("duration").item(0);
					Element distance = (Element) element.getElementsByTagName("distance").item(0);
					googleDistanceMatrixDataForm.setDurationValue(getValue("value", duration));
					googleDistanceMatrixDataForm.setDurationResult(getValue("text", duration));
					googleDistanceMatrixDataForm.setDistanceValue(getValue("value", distance));
					googleDistanceMatrixDataForm.setDistanceResult(getValue("value", distance));
					System.out.println(googleDistanceMatrixDataForm);
				}else if(getValue("status", element).trim().toUpperCase().equals("ZERO_RESULTS")){
					System.out.println("불가능한 경로");
				}
			}
		}

		return null;
	}
}
