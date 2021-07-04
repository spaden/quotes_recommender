package UsersResponse;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	private List<User> usersResponse;
	
	public UserList() {
		this.usersResponse = new ArrayList<User>();
	}

	public List<User> getUsersResponse() {
		return usersResponse;
	}

	public void setUsersResponse(List<User> usersResponse) {
		this.usersResponse = usersResponse;
	}
}
