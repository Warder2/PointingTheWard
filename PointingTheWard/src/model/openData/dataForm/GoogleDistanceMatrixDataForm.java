package model.openData.dataForm;

public class GoogleDistanceMatrixDataForm {
	private String durationValue;
	private String durationResult;
	private String distanceValue;
	private String distanceResult;
	public GoogleDistanceMatrixDataForm(String durationValue, String durationResult, String distanceValue,
			String distanceResult) {
		this.durationValue = durationValue;
		this.durationResult = durationResult;
		this.distanceValue = distanceValue;
		this.distanceResult = distanceResult;
	}
	public GoogleDistanceMatrixDataForm(String durationValue, String distanceValue) {
		this(durationValue,null,distanceValue,null);
	}
	public GoogleDistanceMatrixDataForm() {
		this("0","0","0","0");
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
		return "GoogleDistansMatrixDataForm [durationValue=" + durationValue + ", durationResult=" + durationResult
				+ ", distanceValue=" + distanceValue + ", distanceResult=" + distanceResult + "]";
	}
	
}
