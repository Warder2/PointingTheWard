package model.service;

import model.Abstract.AbstractGroupService;
import model.beans.Group;

public class GroupService extends AbstractGroupService{
	public boolean addGroup(Group group){
		return false;
	}
	public boolean addGroup(int index,Group group){
		return false;
	}
	public Group searchGroupName(String name){
		
		return null;
	}	
	public Group searchGroup(Group group){

		return null;
	}
	
	public boolean modifyGroupName(String name, String newName){		

		return false;
	}
	
	public boolean modifyGroup(String name, Group newGroup){
		
		return false;
	}
	
	public boolean modifyGroup(Group group, Group newGroup){
		
		return false;
	}
	
	public boolean deleteGroupName(String name){

		return false;	
	}
	
}
