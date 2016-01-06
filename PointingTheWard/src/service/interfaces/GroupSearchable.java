package service.interfaces;


import java.util.List;

import model.beans.Group;

public interface GroupSearchable {
	List<Group> searchGroup(String owner);
	Group searchGroup(int gCode);
	List<Group> searchGroupName(String name, String owner);	
}
