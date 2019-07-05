package app.classes;


import java.util.ArrayList;
import java.util.List;

public class Group extends BasicInfo {
	
	public Group(String name,int id)
	{
		super(name,id);
	}
	
List<Group> joinedGroups=new ArrayList<Group>();
private Members member;

public List<User> getUserMembers()
{
	
	return member.getUserMembers();
}

public List<Group> getGroupMember()
{
	return member.getGroupMembers();
}

public List<Group> getJoinedGroups()
{
	return joinedGroups;
}


}
