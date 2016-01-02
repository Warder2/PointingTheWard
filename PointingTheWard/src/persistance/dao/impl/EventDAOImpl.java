package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.viewdto.EventParticipantInfoViewDTO;
import persistance.viewdto.EventParticipantViewDTO;
import persistance.viewdto.EventViewDTO;

public class EventDAOImpl implements EventDAO{

	private JdbcTemplate template;
	private RowMapper<EventDTO> eventDTOMapper = new RowMapper<EventDTO>() {
		@Override
		public EventDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventDTO eventDTO = new EventDTO();
			eventDTO.setCode(rs.getInt("code"));
			eventDTO.setsDate(rs.getString("sDate"));
			eventDTO.seteDate(rs.getString("eDate"));
			eventDTO.setsTime(rs.getString("sTime"));
			eventDTO.seteTime(rs.getString("eTime"));
			eventDTO.setContent("content");
			eventDTO.setPlace("place");
			return eventDTO;
		}
	};
	
	private RowMapper<EventViewDTO> eventViewDTOMapper = new RowMapper<EventViewDTO>(){
		
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
	
	private RowMapper<EventParticipantViewDTO> eventParticipantViewDTOMapper = new RowMapper<EventParticipantViewDTO>(){
		
		public EventParticipantViewDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantViewDTO eventPArticipantViewDTO = new EventParticipantViewDTO();
			
			eventPArticipantViewDTO.setCode(rs.getInt("code"));
			eventPArticipantViewDTO.setEmail(rs.getString("email"));
			return eventPArticipantViewDTO;
		}
	};
	
	private RowMapper<EventParticipantInfoViewDTO> eventParticipantInfoViewDTOMapper = new RowMapper<EventParticipantInfoViewDTO>(){
		
		public EventParticipantInfoViewDTO mapRow(ResultSet rs, int index) throws SQLException {
			EventParticipantInfoViewDTO eventParticipantInfoViewDTO = new EventParticipantInfoViewDTO();
			
			eventParticipantInfoViewDTO.setTitle(rs.getString("title"));
			eventParticipantInfoViewDTO.setContent(rs.getString("content"));
			eventParticipantInfoViewDTO.seteDate(rs.getString("eDate"));
			eventParticipantInfoViewDTO.setsDate(rs.getString("sDate"));
			eventParticipantInfoViewDTO.seteTime(rs.getString("eTime"));
			eventParticipantInfoViewDTO.setsTime(rs.getString("sTime"));
			eventParticipantInfoViewDTO.setPlace(rs.getString("place"));
			return eventParticipantInfoViewDTO;
		}
	};
	
	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}
	
	@Override
	public void eventRegist(String email, Event event) {
		// TODO Auto-generated method stub
		eventRegist(email, event);
	}

	@Override
	public void eventRegist(String email,String title, String content, String sDate, String eDate, String sTime, String eTime,
			Place place, List<Member> participants) {
		template.update("insert into event_view(e_code, title, s_date, e_date, s_time, e_time, content, place values(event_sequence.nextval, ?, ?, ?, ?, ?, ?, ?)"
														,title,sDate,eDate,sTime,eTime,content,place);
		//시발??코드값 어케 뽑음 ...	-> 트리거로 처리
	}
	
	@Override
	public List<EventParticipantInfoViewDTO> eventSearch(String email) {
		
		String sql1 = "select * from event_participant_Info_view where email = ?";
		List<EventParticipantInfoViewDTO> epiList = template.query(sql1, eventParticipantInfoViewDTOMapper, email);
		
		return null;
	}

	@Override
	public List<EventParticipantInfoViewDTO> eventSearchTitle(String email, String title) {
		// title 중복되지 않나

		String sql1 = "select * from event_participant_Info_view where email = ? and title=?";
		return template.query(sql1, eventParticipantInfoViewDTOMapper, email, title);

	}

	@Override
	public List<EventParticipantInfoViewDTO> eventSearchDate(String email, String sDate, String eDate) {
		// TODO Auto-generated method stub
		
		String sql1 = "select * from event_participant_Info_view where email = ? and s_date=? and eDate=?";
		return template.query(sql1, eventParticipantInfoViewDTOMapper, email, sDate , eDate);

	}

	@Override
	public List<EventParticipantInfoViewDTO> eventSearchTime(String email, String sTime, String eTime) {
		// TODO Auto-generated method stub
		
		String sql1 = "select * from event_participant_Info_view where email = ? and time=? and time=?";
		return template.query(sql1, eventParticipantInfoViewDTOMapper, email, sTime , eTime);
	}

	@Override
	public List<EventParticipantInfoViewDTO> eventSearchContent(String email, String content) {
		// TODO Auto-generated method stub
		String sql1 = "select * from event_participant_Info_view where email = ? and content like %?%";
		return template.query(sql1, eventParticipantInfoViewDTOMapper, email, content);
	}

	@Override
	public void eventModify(String email, Event event, Event newEvent) {
		
		
	}

	
	
	@Override
	public void eventDelete(String email) {
		// TODO Auto-generated method stub
		String q = "delete from event_participant_view where email='?'";
		template.update(q,email);
		
		//event_view 도 삭제 -> 트리거 처리 
	}

	@Override
	public void eventDeleteDate(String email, String sDate, String eDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDeleteTime(String email, String sTime, String eTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDelete(String email, String sDate, String eDate, String sTime, String eTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDelete(String email, String title) {
		// TODO Auto-generated method stub
		
	}

}
