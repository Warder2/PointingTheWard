package model.openData;


import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.openData.template.DataGetterDOMTemplate;

public class GoogleDistansMatrixDataGetter extends DataGetterDOMTemplate{
	@Override
	protected <T> List<T> getData(Element root) {
	
		NodeList rows = root.getElementsByTagName("row");
		
		
		for(int rowCnt = 0; rowCnt < rows.getLength(); rowCnt++){
			Element row = (Element)rows.item(rowCnt);
			NodeList elements = row.getElementsByTagName("element");
			for(int elementCnt = 0 ; elementCnt < elements.getLength(); elementCnt++){
				Element element = (Element) elements.item(elementCnt);
				Element duration = (Element)element.getElementsByTagName("duration").item(0);
				System.out.println("duration value : "+getValue("value",duration));
				System.out.println("duration text : "+getValue("text",duration));
				Element distance = (Element)element.getElementsByTagName("distance").item(0);
				System.out.println("distance value : "+getValue("value",distance));
				System.out.println("distance text : "+getValue("text",distance));
			}
		}
		
		return null;
	}
}
