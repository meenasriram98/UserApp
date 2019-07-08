package app.tests;



import static org.junit.Assert.*;

import org.junit.*;

import app.classes.Group;
import app.classes.User;
import app.repositories.GroupRepository;
import app.repositories.UserRepository;
import app.services.GroupService;
import app.services.UserService;

public class GroupServiceTest {
	//GroupService groupService=new GroupService();
	GroupRepository grouprepository=GroupRepository.getInstance();
	UserRepository usersrepository=UserRepository.getInstance();
	
	
	@Test
	public void addGroup() {
		GroupService groupService=new GroupService();
		assertTrue(groupService.addGroup("g",12));
	}
	
	@Test
	public void testGroupPresent() {
		GroupService groupService=new GroupService();
		Group gr=new Group("g2",13);
		grouprepository.addGroup(gr);
		assertTrue(groupService.groupPresent(gr.getName()));
	}

	@Test
	public void testaddGroup() {
		Group gr=new Group("g4",19);
		Group g=new Group("g5",3);
		grouprepository.addGroup(g);
		grouprepository.addGroup(gr);
		assertEquals(4,grouprepository.getSize());
	}
	
	@Test
	public void testRemoveGroup() {
		Group g=new Group("g6",3);
		grouprepository.addGroup(g);
		grouprepository.removeGroup(g.getName());
		assertEquals(2,grouprepository.getSize());
	}

	public void testRemoveGroup1() {
		Group g=new Group("g5",3);
		grouprepository.addGroup(g);
		Group gr=new Group("g6",32);
		grouprepository.addGroup(gr);

		grouprepository.removeGroup("g5");
		assertEquals(2,grouprepository.getSize());
	}

<<<<<<< Updated upstream
	
=======
>>>>>>> Stashed changes
	@Test
	public void testGroupPresent2() {
		assertFalse(grouprepository.getGroup("meena"));
	}

@Test
    public void testremoveGroupFromGroup()
{
	GroupService service=new GroupService();
	Group gr=new Group("g6",19);
	Group g=new Group("g7",3);
	
	grouprepository.addGroup(gr);
	grouprepository.addGroup(g);
	service.saveGroup(g.getName(), gr.getName());
	
	service.removeGroupFromGroup(gr.getName());
	System.out.println(grouprepository.getGroupObject(g.getName()).getJoinedGroups().contains(gr));
	System.out.println(grouprepository.getGroupObject(g.getName()).getJoinedGroups());
	assertEquals(true,grouprepository.getGroupObject(g.getName()).getJoinedGroups().contains(gr));
	
}

<<<<<<< Updated upstream
    
=======

>>>>>>> Stashed changes
    	
}
