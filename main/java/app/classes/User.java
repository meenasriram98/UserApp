package app.classes;
import java.util.ArrayList;
import java.util.List;

public class User extends BasicInfo {

	List<String> member=new ArrayList<String>();
	
	public User(String name,int id)
	{
		super(name,id);
	}
	
	public List<String> getMemberList()
	{
		return member;
	}
	
}
