package services;

import java.util.List;

import models.UserModel;

public interface UserManagement {
	public boolean add(UserModel user);
	public boolean edit(UserModel user);
	public boolean delete(int id);
	public UserModel getUser(int id);
	public List<UserModel> getUsers();
}
