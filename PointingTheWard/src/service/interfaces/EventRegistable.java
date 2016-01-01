package service.interfaces;

import model.beans.Event;
import model.list.MemberList;

public interface EventRegistable {
	public boolean registEvent(Event event);
	public void registEvent(int index, Event event);
	public int registEvent(MemberList members, Event event);
}
