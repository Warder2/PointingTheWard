package service.interfaces;

import model.List.MemberList;
import model.beans.Group;
import model.beans.Member;

public interface GroupModifiable {
	public boolean modifyGroupName(String name, String newName);
	public boolean modifyGroup(String name, Group newGroup);
	public boolean modifyGroup(Group group, Group newGroup);
	public boolean modifyGroupParticipant(Group group,MemberList members);
	public boolean modifyGroupParticipant(String name,MemberList members);
	public boolean modifyGroupParticipantAdd(Group group,Member member);
	public boolean modifyGroupParticipantAdd(String name,Member member);
	public boolean modifyGroupParticipantDropout(Group group,Member member);
	public boolean modifyGroupParticipantDropout(String name,Member member);
}
