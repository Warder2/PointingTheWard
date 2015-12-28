package model.openData;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.openData.dataForm.StoreZoneDataForm;
import model.openData.templete.DataGetterDOMTemplete;

/**
 * DataGetterDOMTemplete 클래스를 상속하여  Restful 방식의 Open API인 공공데이터로 제공하는 소상공인 상가업소 정보 서비스에 요청하여 응답된 데이터들을 DOM parsing 방식으로 parsing 하여 반환 하는 클래스.
 * DataGetterDOMTemplete 클래스의 protected method인 getData() method를 overriding하여 실질적으로 응답되는 xml의 dtd에 맞게 parsing하는 부분을 구현하고 있다. 
 * @author janghae
 *
 */
public class StoreZoneDataGetter extends DataGetterDOMTemplete{
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 실질적으로 응답되는 xml을 parsing하여 객체 리스트를 반환.
	 */
	protected <T> List<T> getData(Element root) {
		NodeList items = root.getElementsByTagName("item");
		List<StoreZoneDataForm> infos = new ArrayList<StoreZoneDataForm>();
		for (int i = 0; i < items.getLength(); i++) {
			Element item = (Element) items.item(i);
			
			StoreZoneDataForm info = new StoreZoneDataForm();
			info.setMainTrarNo(getValue("mainTrarNo", item));
			info.setMainTrarNm(getValue("mainTrarNm", item));
			info.setCtprvnCd(getValue("ctprvnCd", item));
			info.setCtprvnNm(getValue("ctprvnNm", item));
			info.setSignguCd(getValue("signguCd", item));
			info.setSignguNm(getValue("signguNm", item));
			info.setTrarArea(getValue("trarArea", item));
			info.setCoordNum(getValue("coordNum", item));
			info.setCoords(getValue("coords", item));
			info.setStdrDt(getValue("stdrDt", item));
			
			infos.add(info);
		}
		return (List<T>) infos;
	}
}
