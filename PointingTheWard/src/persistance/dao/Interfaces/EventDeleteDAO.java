package persistance.dao.Interfaces;

public interface EventDeleteDAO {
	
	public void eventDeleteDate(String email, String sDate, String eDate);
	public void eventDeleteTime(String email, String sTime, String eTime);
	public void eventDelete(String email, String sDate, String eDate, String sTime, String eTime);
	public void eventDelete(String email, String title);
	public void eventDelete(String email);
}
