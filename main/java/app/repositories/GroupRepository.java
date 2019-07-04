package app.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.classes.Group;

public class GroupRepository {
	
	public static Map<String,Group> groupData=new HashMap<String, Group>();
	
	public static GroupRepository INSTANCE=new GroupRepository();
	
	private GroupRepository()
	{
		
	}
	
	public int getSize()
	{
		return groupData.size();
	}
	
	public static GroupRepository getInstance()
	{
		return INSTANCE;
	}
	
	public void addGroup(Group group)
	{
		groupData.put(group.getName(), group);
	}
	
	public boolean getGroup(String name)
	{
		return groupData.containsKey(name);
	}
	
	public List<Group> getGroupList()
	{
		return groupData.values().stream().collect(Collectors.toList());
		
	}
	
	public void removeGroup(String name)
	{
		groupData.remove(name);
		System.out.println("group removed");
	}

	public void updateRepository(Group group)
	{
		groupData.put(group.getName(), group);
	}
	
	public Group getGroupObject(String name)
	{
		return groupData.get(name);
	}

	
}
