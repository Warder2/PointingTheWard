package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.beans.Transportation;
import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.dto.EventParticipantDTO;
import persistance.dto.EventParticipantInfoDTO;

public class EventDAOImpl implements EventDAO {

	private JdbcTemplate template;

	private RowMapper<EventDTO> EventDTOMapper = new RowMapper<EventDTO>() {

		public EventDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventDTO EventDTO = new EventDTO();

			EventDTO.setCode(rs.getInt("e_code"));
			EventDTO.setTitle(rs.getString("title"));
			EventDTO.seteDate(rs.getString("e_Date"));
			EventDTO.setsDate(rs.getString("s_Date"));
			EventDTO.seteTime(rs.getString("e_Time"));
			EventDTO.setsTime(rs.getString("s_Time"));
			EventDTO.setContent(rs.getString("content"));
			EventDTO.setPlace(rs.getString("place"));

			return EventDTO;
		}
	};

	private RowMapper<EventParticipantDTO> eventParticipantViewDTOMapper = new RowMapper<EventParticipantDTO>() {

		public EventParticipantDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantDTO eventPArticipantViewDTO = new EventParticipantDTO();

			eventPArticipantViewDTO.setCode(rs.getInt("e_code"));
			eventPArticipantViewDTO.setEmail(rs.getString("email"));
			return eventPArticipantViewDTO;
		}
	};

	private RowMapper<EventParticipantInfoDTO> eventParticipantInfoViewDTOMapper = new RowMapper<EventParticipantInfoDTO>() {

		public EventParticipantInfoDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantInfoDTO eventParticipantInfoViewDTO = new EventParticipantInfoDTO();

			eventParticipantInfoViewDTO.setEventCode(rs.getInt("e_code"));
			eventParticipantInfoViewDTO.setEmail(rs.getString("email"));
			eventParticipantInfoViewDTO.setTitle(rs.getString("title"));
			eventParticipantInfoViewDTO.seteDate(rs.getString("e_date"));
			eventParticipantInfoViewDTO.setsDate(rs.getString("s_date"));
			eventParticipantInfoViewDTO.seteTime(rs.getString("e_time"));
			eventParticipantInfoViewDTO.setsTime(rs.getString("s_time"));
			eventParticipantInfoViewDTO.setContent(rs.getString("content"));
			eventParticipantInfoViewDTO.setPlace(rs.getString("place"));
			eventParticipantInfoViewDTO.setName(rs.getString("name"));
			eventParticipantInfoViewDTO.setLocation(rs.getString("location"));
			eventParticipantInfoViewDTO.setTransportation(Transportation.valueOfByStr(rs.getString("transportation")));
			return eventParticipantInfoViewDTO;
		}
	};

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// event delete

	@Override
	public void eventDelete(int eventCode) {

		String q = "delete from event_view where e_code=?";
		template.update(q, eventCode);

		// 트리거 eventParticipant 처리 필요
	}

	// eventParticipant delete

	@Override
	public void eventParticipantDelete(String email) {

		String q = "delete from e_participant_view where email=?";
		template.update(q, email);

		// 트리거 event 처리 필요
	}

	@Override
	public void eventParticipantDelete(String email, int eventCode) {

		String q = "delete from e_participant_view where email=? and e_code =?";
		template.update(q, email, eventCode);
	}

	// event modify

	@Override
	public void eventModify(EventDTO oldEvent, EventDTO newEvent) {
		// TODO Auto-generated method stub
		String q = "update event_view set " + "title=?, " + "s_date=?, " + "e_date=?, " + "s_time=?, " + "e_time=?, "
				+ "content=?, " + "place=?" + "where e_code= ?";
		template.update(q, newEvent.getTitle(), newEvent.getsDate(), newEvent.geteDate(), newEvent.getsTime(),
				newEvent.geteTime(), newEvent.getContent(), newEvent.getPlace(), oldEvent.getCode());
	}

	@Override
	public void eventModifyCode(int eventCode, EventDTO newEvent) {
		// TODO Auto-generated method stub
		String q = "update event_view set " + "title=?, " + "s_date=?, " + "e_date=?, " + "s_time=?, " + "e_time=?, "
				+ "content=?, " + "place=?" + "where e_code= ?";
		template.update(q, newEvent.getTitle(), newEvent.getsDate(), newEvent.geteDate(), newEvent.getsTime(),
				newEvent.geteTime(), newEvent.getContent(), newEvent.getPlace(), eventCode);
	}

	// event search

	@Override
	public EventDTO eventSearchCode(int eventCode) {

		String q = "select * from event_view where e_code = ?";
		return template.queryForObject(q, EventDTOMapper, eventCode);

	}

	@Override
	public List<EventDTO> eventSearch(EventDTO event) {
		String q = "select * from event_view where " + "title = ? and " + "s_date = ? and " + "e_date = ? and "
				+ "s_time = ? and " + "e_time = ? and " + "content = ? and " + "place = ? ";

		return template.query(q, EventDTOMapper, event.getTitle(), event.getsDate(), event.geteDate(), event.getsTime(),
				event.geteTime(), event.getContent(), event.getPlace());
	}

	@Override

	public List<EventDTO> eventSearchRangeDate(String sDate, String eDate) {
		String q = "select * from event_view where s_date >= ? and e_date <=?";
		return template.query(q, EventDTOMapper, sDate, eDate);
	}

	@Override
	public List<EventDTO> eventSearchScope(int scope) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		// String currentDate = formatter.format(rightNow.getTime());
		rightNow.add(Calendar.DATE, scope);
		String scopeDate = formatter.format(rightNow.getTime());

		System.out.println(scopeDate);

		String q = "select * from event_view where s_date >= to_char(sysdate, 'yyyy-mm-dd') and e_date <= ?";
		return template.query(q, EventDTOMapper, scopeDate);

	}

	@Override
	public List<EventDTO> eventSearchRangeTime(String date, String sTime, String eTime) {

		String q = "select * from event_view where s_date = ? and e_date = ? and s_time >=? and e_time <= ?";
		return template.query(q, EventDTOMapper, date, date, sTime, eTime);
	}

	// eventParticipant Info search

	@Override
	public EventParticipantInfoDTO eventParticipantInfoSearch(String email, int eventCode) {

		String q = "select * from e_participant_info_view where email=? and e_code=?";
		return template.queryForObject(q, eventParticipantInfoViewDTOMapper, email, eventCode);
	}

	@Override
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchMail(String email) {

		String q = "select * from e_participant_info_view where email=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, email);

	}

	@Override
	public EventParticipantInfoDTO eventParticipantInfoSearchCode(int eventCode) {

		String q = "select * from e_participant_info_view where e_code=?";
		return template.queryForObject(q, eventParticipantInfoViewDTOMapper, eventCode);

	}

	// eventParticipant search

	@Override
	public List<EventParticipantDTO> eventParticipantSearchMail(String email) {
		String q = "select * from e_participant_view where email=?";
		return template.query(q, eventParticipantViewDTOMapper, email);
	}

	@Override
	public List<EventParticipantDTO> eventParticipantSearchCode(int eventCode) {
		String q = "select * from e_participant_view where e_code=?";
		return template.query(q, eventParticipantViewDTOMapper, eventCode);
	}

	@Override
	public EventParticipantDTO eventParticipantSearch(String email, int eventCode) {
		String q = "select * from e_participant_view where e_code=? and email=?";
		return template.queryForObject(q, eventParticipantViewDTOMapper, eventCode, email);
	}

	// event regist

	@Override
	public void eventRegist(EventDTO event) {

		eventRegist(event.getTitle(), event.getContent(), event.getsDate(), event.geteDate(), event.getsTime(),
				event.geteTime(), event.getPlace());

	}

	@Override
	public void eventRegist(String title, String content, String sDate, String eDate, String sTime, String eTime,
			String place) {

		String q = "insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place) values(event_sequence.nextval, ?, ?, ?, ?, ?, ?, ?)";
		template.update(q, title, sDate, eDate, sTime, eTime, content, place);

	}

	// eventParticipant regist

	@Override
	public void eventParticipantRegist(String email, EventDTO event) {
		String q = "insert into e_participant_view(email,e_code) values(?,?)";
		template.update(q, email, event.getCode());
	}

	@Override
	public List<EventDTO> eventSearchAll() {
		String q = "select * from event_view";

		return template.query(q, EventDTOMapper);
	}

}
