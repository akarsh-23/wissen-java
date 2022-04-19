package daos;

import java.util.List;

import models.UserModel;

public interface User {
	public boolean add(UserModel user);
	public boolean edit(UserModel user);
	public boolean delete(int id);
	public UserModel getUser(int id);
	public List<UserModel> getUsers();
}
