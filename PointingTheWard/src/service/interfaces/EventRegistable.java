package service.interfaces;

import model.List.MemberList;
import model.beans.Event;

public interface EventRegistable {
	public boolean registEvent(Event event);
	public void registEvent(int index, Event event);
	public int registEvent(MemberList members, Event event);
}
