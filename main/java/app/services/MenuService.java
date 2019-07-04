package app.services;

import java.util.Scanner;

public class MenuService {
	
	public void printMenu()
	{
		System.out.println("1. Create User  2. Create Group 3. RemoveUser 4. Remove Group 5. Add user to group"
				+ "6. Remove user from group 7. Add group to a group");
		processMenu();
	}
	
	public void processMenu()
	{
		UserService userservice=new UserService();
		GroupService groupservice=new GroupService();
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		while(true)
		{
			if(input==1)
			{
				userservice.createUser();
			}
			else if(input==2)
			{
			    groupservice.createGroup();
			}
			else if(input==3)
			{
				userservice.removeUser();
			}
			else if(input==4)
			{
				groupservice.removeGroup();
			}
			else if(input==5)
			{
				groupservice.addUserToGroup();
			}
			else if(input==6)
			{
				groupservice.removeUserFromGroup();
			}
			else if(input==7)
			{
				groupservice.addGroupToGroup();
			}
			else
			{
				break;
			}
			printMenu();
			processMenu();
		}
	}

}
