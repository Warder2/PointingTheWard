package model.openData.templete;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DataGetterTemplete을 상속하여 Restful 방식의 Open API로 요청을 하여 응답 결과를 DOM parsing 방식으로 처리 하는 클래스를 템플릿화 하였다.
 * open API를 이용하고 DOM parsing 방식으로 응답을 처리하는 여러 클래스들은 이 클래스를 상속 받음으로써 open API 서버의 응답을 DOM parsing 방식으로 처리 하는 부분을 그대로 쓸 수 있다.  
 * @author janghae
 *
 */
public abstract class DataGetterDOMTemplete extends DataGetterTemplete{
	/**
	 * DataGetterTemplete 클래스의 protected method인 getData() method를 overriding 했다.
	 * open API 서버의 응답을 DOM parsing 방식으로 처리하는 부분을 정의했다. 실질적으로 응답 데이터를 parsing 하여 데이터를 반환하는 부분을 분리하여 구현 객체에서 정의할 것을 위임한다.
	 */
	@Override
	protected <T> List<T> getData(InputStream inputStream) throws IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<T> infos = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputStream);
			if (document.hasChildNodes()) {
				Element root = document.getDocumentElement();
				System.out.println(root.getNodeName());
				infos = getData(root);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return (List<T>) infos;
	}
	protected String getValue(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list.getLength() > 0) {
			return ((Element) (list.item(0))).getTextContent();
		}
		return null;
	}
	
	/**
	 * 실질적으로 응답 데이터를 parsing 하여 데이터를 반환하는 부분을 분리하여 구현 객체에서 정의할 것을 위임한다.
	 * @param root
	 * 응답된 xml의 root element
	 * @return
	 * open API로부터 응답된 데이터들
	 */
	protected abstract <T> List<T> getData(Element root);
}
