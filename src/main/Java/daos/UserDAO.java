package daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import models.UserModel;

@Repository("userDAO")
public class UserDAO implements User {

	private static final String ADD_USER = "INSERT INTO USER(NAME,AGE) VALUES(?,?)";
	private static final String EDIT_USER = "UPDATE USER SET NAME=?, AGE=? WHERE ID=?";
	private static final String DELETE_USER = "DELETE FROM USER WHERE ID=?";
	private static final String GET_USER = "SELECT * FROM USER WHERE ID=?";
	private static final String GET_USERS = "SELECT * FROM USER";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public boolean add(UserModel user) {
		int count = jt.update(ADD_USER,user.getName(),user.getAge());
		return count>0?true:false;
	}

	@Override
	public boolean edit(UserModel user) {
		int count = jt.update(EDIT_USER,user.getName(),user.getAge(),user.getId());
		return count>0?true:false;
	}

	@Override
	public boolean delete(int id) {
		int count = jt.update(DELETE_USER,id);
		return count>0?true:false;
	}

	@Override
	public UserModel getUser(int id) {
		UserModel user = jt.queryForObject(GET_USER, (rs, rownum)->{
			UserModel u = new UserModel();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setAge(rs.getInt(3));
			return u;
		}, id);
		return user;
	}

	@Override
	public List<UserModel> getUsers() {
		List<UserModel> users = jt.query(GET_USERS, (rs)->{
			List<UserModel> list = new ArrayList<UserModel>();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				list.add(user);
			}
			return list;
		});
		return users;
	}

}
