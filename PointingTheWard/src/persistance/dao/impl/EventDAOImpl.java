package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.dto.EventParticipantDTO;
import persistance.dto.EventParticipantInfoDTO;

public class EventDAOImpl implements EventDAO {

	private JdbcTemplate template;

	private RowMapper<EventDTO> EventDTOMapper = new RowMapper<EventDTO>() {

		public EventDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventDTO EventDTO = new EventDTO();

			EventDTO.setCode(rs.getInt("code"));
			EventDTO.setTitle(rs.getString("title"));
			EventDTO.setContent(rs.getString("content"));
			EventDTO.seteDate(rs.getString("eDate"));
			EventDTO.setsDate(rs.getString("sDate"));
			EventDTO.seteTime(rs.getString("eTime"));
			EventDTO.setsTime(rs.getString("sTime"));
			EventDTO.setPlace(rs.getString("place"));
			return EventDTO;
		}
	};

	private RowMapper<EventParticipantDTO> eventParticipantViewDTOMapper = new RowMapper<EventParticipantDTO>() {

		public EventParticipantDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantDTO eventPArticipantViewDTO = new EventParticipantDTO();

			eventPArticipantViewDTO.setCode(rs.getInt("code"));
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
	public EventDTO eventSearchCode(int eventCode) {

		String q = "select * from event_view where e_code = ?";
		return template.queryForObject(q, EventDTOMapper, eventCode);

	}

	// eventParticipant Info search

	@Override
	public List<EventParticipantInfoDTO> eventParticipantInfoSearch(String email, int eventCode) {

		String q = "select * from e_participant_info_view where email=? and e_code=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, email, eventCode);
	}

	@Override
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchMail(String email) {

		String q = "select * from e_participant_info_view where email=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, email);

	}

	@Override
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchCode(int eventCode) {

		String q = "select * from e_participant_info_view where e_code=?";
		return template.query(q, eventParticipantInfoViewDTOMapper, eventCode);

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
	public List<EventParticipantDTO> eventParticipantSearch(String email, int eventCode) {
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
