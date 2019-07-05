package app.tests;


import static org.junit.Assert.*;

import org.junit.*;

import app.classes.User;
import app.repositories.UserRepository;
import app.services.UserService;

public class UserServiceTest {
	
	UserRepository usersrepository=UserRepository.getInstance();
	UserService service=new UserService();
	
	
	@Test
	public void testSaveUser() {
		service.saveUser("user1", 45);
		assertEquals(1,usersrepository.getSize());
	}

	@Test
	public void testUserPresent() {
		assertTrue(service.userPresent("user1"));
	}

//	@Test
//	public void testRemoveUser() {
//		usersrepository.removeUser("user1");
//		assertEquals(0,usersrepository.userData.size());
//	}
	
	@Test
	public void testGetUserObject()
	{
		service.saveUser("user2", 56);
		assertEquals("user2",service.getUserObject("user2").getName());
	}

}
