package model.openData;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 여러 요청 정보를 가진 RequestInfo 클래스.
 * open API 서버에 요청할 때 필요한 요청 정보 및 url을 캡슐화하고 있다.
 * 내부적으로 요청 url을 만들어서 제공한다.
 * @author janghae
 *
 */
public class RequestInfo {
	public enum RequestMethod{
		GET("GET"), POST("POST");
		private String str;
		
		private RequestMethod(String str){
			this.str = str;
		}
		public String getStr() {
			return str;
		}
	}
	
	public enum EncodingType{
		UTF8("UTF-8");
		private String str;
		private EncodingType(String str){
			this.str = str;
		}
		public String getStr() {
			return str;
		}
	}
	
	private String url;
	private Map<String, String> parameters;
	private RequestMethod requestMethod;
	private String contentType;
	private EncodingType encodingType;
	private String appKey;
	private String appKeyParameter;
	
	public RequestInfo() {
	}
	public RequestInfo(String url) {
		this(url, null, RequestMethod.GET, "application/json", EncodingType.UTF8);
	}
	public RequestInfo(String url, Map<String, String> parameters) {
		this(url, parameters, RequestMethod.GET, "application/json", EncodingType.UTF8);
	}
	public RequestInfo(String url, Map<String, String> parameters, String appKey, String appKeyParameter) {
		this(url, parameters, RequestMethod.GET, "application/json", EncodingType.UTF8, appKey, appKeyParameter);
	}
	public RequestInfo(String url, String appKey, String appKeyParameter) {
		this(url, null, RequestMethod.GET, "application/json", EncodingType.UTF8, appKey, appKeyParameter);
	}
	/**
	 * @param url
	 * @param parameters
	 * @param requestMethod
	 * @param contentType
	 * @param encodingType
	 */
	public RequestInfo(String url, Map<String, String> parameters, RequestMethod requestMethod, String contentType,
			EncodingType encodingType) {
		this(url, parameters, requestMethod, contentType, encodingType, null, null);
	}
	/**
	 * @param url
	 * @param parameters
	 * @param requestMethod
	 * @param contentType
	 * @param encodingType
	 * @param appKey
	 * @param appKeyParameter
	 */
	public RequestInfo(String url, Map<String, String> parameters, RequestMethod requestMethod, String contentType,
			EncodingType encodingType, String appKey, String appKeyParameter) {
		this.url = url;
		this.parameters = parameters;
		this.requestMethod = requestMethod;
		this.contentType = contentType;
		this.encodingType = encodingType;
		this.appKey = appKey;
		this.appKeyParameter = appKeyParameter;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	public RequestMethod getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setEncodingType(EncodingType encodingType) {
		this.encodingType = encodingType;
	}
	public EncodingType getEncodingType() {
		return encodingType;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppKeyParameter() {
		return appKeyParameter;
	}
	public void setAppKeyParameter(String appKeyParameter) {
		this.appKeyParameter = appKeyParameter;
	}
	public boolean existAppKey(){
		if(appKey == null){
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "RequestInfo [url=" + url + ", parameters=" + parameters + ", requestMethod=" + requestMethod
				+ ", contentType=" + contentType + ", encodingType=" + encodingType + ", appKey=" + appKey
				+ ", appKeyParameter=" + appKeyParameter + "]";
	}
	/**
	 * url에 요청 정보들을 만들어서 반환한다.
	 * GET 방식의 경우 url에 query string을 붙여서 요청을 한다.
	 * url에 요청 정보들을 query string으로 붙여서 반환한다.
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getRequestURL() throws UnsupportedEncodingException{
		StringBuilder urlBuilder = new StringBuilder(getUrl()); /*URL*/
		urlBuilder.append("?");
		urlBuilder.append(getRequestBody());
		return urlBuilder.toString();
	}
	
	/**
	 * 요청 정보들을 웹 표준에 맞춰 String으로 만들어서 반환한다.
	 * @return
	 * 요청 정보
	 * @throws UnsupportedEncodingException
	 */
	public String getRequestBody() throws UnsupportedEncodingException{
		StringBuilder rquestBodyBuilder = new StringBuilder();
		String encoding = getEncodingType().getStr();
		if(existAppKey()){
			rquestBodyBuilder.append(URLEncoder.encode(getAppKey(), encoding) + "=" + getAppKeyParameter() + "&");
		}
		if(getParameters() != null && !getParameters().isEmpty()){
			Set<Entry<String, String>> set = getParameters().entrySet();
			for(Entry<String, String> entry : set){
				rquestBodyBuilder.append(URLEncoder.encode(entry.getKey(), encoding) + "=" + URLEncoder.encode(entry.getValue(), encoding) + "&");
			}
		}
		return rquestBodyBuilder.toString();
	}
}
