package model.openDataVO;

public class GoogleGeocoding {
	private String address;
	private String latitude;
	private String longitude;
	private String googlePlaceId;
	public GoogleGeocoding() {
		this("address","latitude","longitude","googlePlaceId");
	}
	public GoogleGeocoding(String address, String latitude, String longitude, String googlePlaceId) {
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.googlePlaceId = googlePlaceId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getGooglePlaceId() {
		return googlePlaceId;
	}
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}
	@Override
	public String toString() {
		return "GoogleGeocoding [address=" + address + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", googlePlaceId=" + googlePlaceId + "]";
	}
}
