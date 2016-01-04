package persistance.dao.Interfaces;

public interface EventDeleteDAO {
	public void eventDelete(int eventCode);
	public void eventParticipantDelete(String email);
	public void eventParticipantDelete(String email, int eventCode);
}
