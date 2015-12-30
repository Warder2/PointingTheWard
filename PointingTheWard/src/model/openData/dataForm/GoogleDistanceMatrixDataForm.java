package model.openData.dataForm;

public class GoogleDistanceMatrixDataForm {
	private String origins;
	private String destination;
	private String durationValue;
	private String durationResult;
	private String distanceValue;
	private String distanceResult;
	public GoogleDistanceMatrixDataForm() {
		super();
	}
	public GoogleDistanceMatrixDataForm(String origins, String destination, String durationValue,
			String distanceValue) {
		super();
		this.origins = origins;
		this.destination = destination;
		this.durationValue = durationValue;
		this.distanceValue = distanceValue;
	}
	public GoogleDistanceMatrixDataForm(String origins, String destination, String durationValue, String durationResult,
			String distanceValue, String distanceResult) {
		super();
		this.origins = origins;
		this.destination = destination;
		this.durationValue = durationValue;
		this.durationResult = durationResult;
		this.distanceValue = distanceValue;
		this.distanceResult = distanceResult;
	}
	public String getOrigins() {
		return origins;
	}
	public void setOrigins(String origins) {
		this.origins = origins;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDurationValue() {
		return durationValue;
	}
	public void setDurationValue(String durationValue) {
		this.durationValue = durationValue;
	}
	public String getDurationResult() {
		return durationResult;
	}
	public void setDurationResult(String durationResult) {
		this.durationResult = durationResult;
	}
	public String getDistanceValue() {
		return distanceValue;
	}
	public void setDistanceValue(String distanceValue) {
		this.distanceValue = distanceValue;
	}
	public String getDistanceResult() {
		return distanceResult;
	}
	public void setDistanceResult(String distanceResult) {
		this.distanceResult = distanceResult;
	}
	@Override
	public String toString() {
		return "GoogleDistanceMatrixDataForm [origins=" + origins + ", destination=" + destination + ", durationValue="
				+ durationValue + ", durationResult=" + durationResult + ", distanceValue=" + distanceValue
				+ ", distanceResult=" + distanceResult + "]";
	}
}
