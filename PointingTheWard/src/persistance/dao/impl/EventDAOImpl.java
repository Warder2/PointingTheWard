package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.viewdto.EventParticipantInfoViewDTO;
import persistance.viewdto.EventParticipantViewDTO;
import persistance.viewdto.EventViewDTO;

public class EventDAOImpl implements EventDAO {

	private JdbcTemplate template;

	private RowMapper<EventViewDTO> eventViewDTOMapper = new RowMapper<EventViewDTO>() {

		public EventViewDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventViewDTO eventViewDTO = new EventViewDTO();

			eventViewDTO.setCode(rs.getInt("code"));
			eventViewDTO.setTitle(rs.getString("title"));
			eventViewDTO.setContent(rs.getString("content"));
			eventViewDTO.seteDate(rs.getString("eDate"));
			eventViewDTO.setsDate(rs.getString("sDate"));
			eventViewDTO.seteTime(rs.getString("eTime"));
			eventViewDTO.setsTime(rs.getString("sTime"));
			eventViewDTO.setPlace(rs.getString("place"));
			return eventViewDTO;
		}
	};

	private RowMapper<EventParticipantViewDTO> eventParticipantViewDTOMapper = new RowMapper<EventParticipantViewDTO>() {

		public EventParticipantViewDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantViewDTO eventPArticipantViewDTO = new EventParticipantViewDTO();

			eventPArticipantViewDTO.setCode(rs.getInt("code"));
			eventPArticipantViewDTO.setEmail(rs.getString("email"));
			return eventPArticipantViewDTO;
		}
	};

	private RowMapper<EventParticipantInfoViewDTO> eventParticipantInfoViewDTOMapper = new RowMapper<EventParticipantInfoViewDTO>() {

		public EventParticipantInfoViewDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantInfoViewDTO eventParticipantInfoViewDTO = new EventParticipantInfoViewDTO();

			eventParticipantInfoViewDTO.setEventCode(rs.getInt("e_code"));
			eventParticipantInfoViewDTO.setEmail(rs.getString("email"));
			eventParticipantInfoViewDTO.setTitle(rs.getString("title"));
			eventParticipantInfoViewDTO.seteDate(rs.getString("e_date"));
			eventParticipantInfoViewDTO.setsDate(rs.getString("s_date"));
			eventParticipantInfoViewDTO.seteTime(rs.getString("e_time"));
			eventParticipantInfoViewDTO.setsTime(rs.getString("s_time"));
			eventParticipantInfoViewDTO.setContent(rs.getString("content"));
			eventParticipantInfoViewDTO.setPlace(rs.getString("place"));
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

	}

	@Override
	public void eventModify(int eventCode, EventDTO newEvent) {
		// TODO Auto-generated method stub

	}

	// eventParticipant Modify

	@Override
	public void eventParticipantModify(String email, EventDTO newEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventParticipantModift(String email, int eventCode) {
		// TODO Auto-generated method stub

	}

	// event search

	@Override
	public EventViewDTO eventSearchCode(int eventCode) {

		String q = "select * from event_view where e_code = ?";
		return template.queryForObject(q, eventViewDTOMapper, eventCode);

	}

	// eventParticipant Info search

	@Override
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearch(String email, int eventCode) {

		String q = "select * from e_participant_info_view where email=? and e_code=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, email, eventCode);
	}

	@Override
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearchMail(String email) {

		String q = "select * from e_participant_info_view where email=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, email);

	}

	@Override
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearchCode(int eventCode) {

		String q = "select * from e_participant_info_view where e_code=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, eventCode);

	}

	// eventParticipant search

	@Override
	public List<EventParticipantViewDTO> eventParticipantSearchMail(String email) {
		String q = "select * from e_participant_view where email=?";
		return template.query(q, eventParticipantViewDTOMapper, email);
	}

	@Override
	public List<EventParticipantViewDTO> eventParticipantSearchCode(int eventCode) {
		String q = "select * from e_participant_view where e_code=?";
		return template.query(q, eventParticipantViewDTOMapper, eventCode);
	}

	@Override
	public List<EventParticipantViewDTO> eventParticipantSearch(String email, int eventCode) {
		String q = "select * from e_participant_view where e_code=? and email=?";
		return template.query(q, eventParticipantViewDTOMapper, eventCode, email);
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
		template.update(q,email,event.getCode());
	}


}
