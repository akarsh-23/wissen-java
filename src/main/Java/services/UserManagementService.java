package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.User;
import models.UserModel;

@Service("userManagementService")
public class UserManagementService implements UserManagement {

	@Autowired
	private User user;
	
	@Override
	public boolean add(UserModel user) {
		return this.user.add(user);
	}

	@Override
	public boolean edit(UserModel user) {
		return this.user.edit(user);
	}

	@Override
	public boolean delete(int id) {
		return this.user.delete(id);
	}

	@Override
	public UserModel getUser(int id) {
		return this.user.getUser(id);
	}

	@Override
	public List<UserModel> getUsers() {
		return this.user.getUsers();
	}

}
