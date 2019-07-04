package app.classes;

import java.util.ArrayList;
import java.util.List;

public class Members {

	List<User> userMembers=new ArrayList<User>();
	List<Group> groupMembers=new ArrayList<Group>();

	public List<User> getUserMembers()
	{
		return userMembers;
	}
	
	public List<Group> getGroupMembers()
	{
		return groupMembers;
	}
}
