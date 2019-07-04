package app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.classes.User;

public class UserRepository {
	
	public static Map<String,User> userData=new HashMap<>();
	
	public static UserRepository INSTANCE=new UserRepository();
	
	private UserRepository()
	{
		
	}
	
	public static UserRepository getInstance()
	{
		return INSTANCE;
	}
	
	public int getSize()
	{
		return userData.size();
	}
	
	public void addUser(User user)
	{
		userData.put(user.getName(), user);
	}
	
	public List<User> listOfUsers()
	{
		List<User> list=new ArrayList<>();
		list=userData.values().stream().collect(Collectors.toList());
		return list;
	}
	
	public boolean getUser(String name)
	{
		return userData.containsKey(name);
	}
	
	public void removeUser(String name)
	{
		userData.remove(name);
		System.out.println("user removed");
	}

	public User getUserObject(String userName) {
		return userData.get(userName);
	}
	
	public void updateRepository(User user)
	{
		userData.put(user.getName(), user);
	}
}
