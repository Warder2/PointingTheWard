package model.openData.template;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import model.openData.RequestInfo;

/**
 * Restful 방식의 Open API로 요청을 하여 결과를 받아오는 클래스를 템플릿화 하였다. 요청 정보를 가진 RequestInfo
 * 객체를 전달 받고 open API의 서버로 요청 하고 결과를 반환하는 부분을 public method인 getData() method로
 * 템플릿화 하고, DataGetterTemplete 클래스를 상속 받는 클래스에서 abstract method인 getData()
 * method를 overriding함으로써 구체적으로 어떻게 데이터를 받아서 처리할 것인지 정한다. open API를 이용하는 여러
 * 클래스들은 이 클래스를 상속 받음으로써 open API의 서버로 요청 하고 응답 받는 부분을 그대로 쓸 수 있다.
 * @author janghae
 *
 */
public abstract class DataGetterTemplate {
	/**
	 * 사용자는 DataGetterTemplete의 public method인 getData() method에 여러 요청 정보를 가진
	 * RequestInfo 객체를 전달하여 getData() methid를 호출한다. 여러 요청 정보를 가진 RequestInfo
	 * 클래스에서 요청 url을 만들고 이 DataGetterTemplete 클래스의 getData 메소드에서는 이 요청 url을 가지고
	 * open API의 서버로 요청을 한다. 응답 결과를 받는 부분에서 abstract method인 getData() method를
	 * 호출하여 구현 객체에서 구현 방법을 정의하도록 하였다.
	 * 
	 * @param requestInfo
	 *            여러 요청 정보를 가진 RequestInfo 객체
	 * @return open API로부터 응답된 데이터들
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public <T> List<T> getData(RequestInfo requestInfo) throws UnsupportedEncodingException, IOException {
		URL requestUrl = null;
		HttpURLConnection conn = null;

		if (requestInfo.getRequestMethod().equals(RequestInfo.RequestMethod.GET)) {
			requestUrl = new URL(requestInfo.getRequestURL());
			conn = (HttpURLConnection) requestUrl.openConnection();
			conn.setRequestMethod(requestInfo.getRequestMethod().getStr());
			conn.setRequestProperty("Content-type", requestInfo.getContentType());
		} else if (requestInfo.getRequestMethod().equals(RequestInfo.RequestMethod.POST)) {
			requestUrl = new URL(requestInfo.getUrl());
			conn = (HttpURLConnection) requestUrl.openConnection();
			conn.setRequestMethod(requestInfo.getRequestMethod().getStr());
			conn.setRequestProperty("Content-type", requestInfo.getContentType());
			conn.setDoOutput(true);
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.writeBytes(requestInfo.getRequestBody());
			os.flush();
			os.close();
		}
		System.out.println("Response code: " + conn.getResponseCode());

		List<T> data = null;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			data = getData(conn.getInputStream());
		} else {
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
		}
		conn.disconnect();

		return data;
	}

	/**
	 * 실질적으로 open API의 응답을 처리하는 메소드를 구현 객체에서 구현하도록 위임한다. 이를 구현하는 객체에서는 어떻게 응답을
	 * 처리하여 데이터를 반환할 지 결정한다.
	 * 
	 * @param inputStream
	 *            open API의 응답 stream
	 * @return open API로부터 응답된 데이터들
	 * @throws IOException
	 */
	protected abstract <T> List<T> getData(InputStream inputStream) throws IOException;
}
