package app.services;

import java.util.List;
import java.util.Scanner;

import app.classes.*;
import app.repositories.*;

public class GroupService {
	Scanner sc=new Scanner(System.in);
	
	UserService userService=new UserService();
	GroupRepository grouprepository=GroupRepository.getInstance();
	
	public boolean addGroup(String name,int id)
	{
		Group group=new Group(name,id);
		grouprepository.addGroup(group);
		System.out.println("group created");
		return true;
	}
	
	public void createGroup()
	{
		System.out.println("enter group name");
		String name=sc.nextLine();
		
		System.out.println("enter group id");
		int id=sc.nextInt();
		
		addGroup(name,id);
	}
	
	public void removeGroup()
	{
		System.out.println("Enter group name");
		String name=sc.nextLine();
		
		if(!groupPresent(name))
		{
			System.out.println("group not present");
		}
		else
		{
		removeGroupFromGroup(name);
		userService.removeGroupFromUser(name);
		grouprepository.removeGroup(name);
		System.out.println("group removed");
		}
		
	}
	
	public void removeGroupFromGroup(String name) {
		
			List<Group> groups=grouprepository.getGroupList();
			
			groups.forEach(group->{group.getJoinedGroups().removeIf(x->x.equals(name));
			grouprepository.updateRepository(group);});

		
	}

	public void addUserToGroup()
	{
		System.out.println("Enter user name");
		String userName=sc.nextLine();
		
		System.out.println("Enter group name");
		String groupName=sc.nextLine();
		
		if(userService.userPresent(userName)&&groupPresent(groupName))
		{
			saveUserToGroup(userName,groupName);
			System.out.println("user added to group");
		}
		else
		{
			System.out.println("invalid info entered");
		}
		
	}
	
	public void saveUserToGroup(String userName,String groupName)
	{
		Group group=grouprepository.getGroupObject(groupName);
		group.getUserMembers().add(userService.getUserObject(userName));
		grouprepository.updateRepository(group);
	}
	
	public void removeUserFromGroup()
	{
		System.out.println("Enter user name");
		String userName=sc.nextLine();
		
		System.out.println("Enter group name");
		String groupName=sc.nextLine();
		
		if(userService.userPresent(userName)&&groupPresent(groupName))
		{
			removeUser(userName,groupName);
		}
		else
		{
			System.out.println("invalid info entered");
		}
	}
	
	public void removeUser(String userName, String groupName) {
		Group group=grouprepository.getGroupObject(groupName);
		group.getUserMembers().remove(userService.getUserObject(userName));
		grouprepository.updateRepository(group);
		
	}

	public void addGroupToGroup()
	{
		System.out.println("Enter group name");
		String group=sc.nextLine();
		
		System.out.println("Enter group name to be added");
		String memberGroup=sc.nextLine();
		
		if(groupPresent(group)&&groupPresent(memberGroup))
		{
			saveGroup(group,memberGroup);
			System.out.println("group added");
		}
		else
		{
			System.out.println("invalid info entered");
		}
	}
	
	public void saveGroup(String group, String memberGroup) {
		
		Group g=grouprepository.getGroupObject(group);
		g.getJoinedGroups().add(grouprepository.getGroupObject(memberGroup));
		grouprepository.updateRepository(g);
		
	}

	public boolean groupPresent(String name)
	{
		return grouprepository.getGroup(name);
	}

	public void removeUserFromAllGroups(String name)
	{
		List<Group> groups=grouprepository.getGroupList();
		
		groups.forEach(group->{group.getUserMembers().removeIf(x->x.equals(name));
		grouprepository.updateRepository(group);});
	}
}
