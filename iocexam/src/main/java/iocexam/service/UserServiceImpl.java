package iocexam.service;

import iocexam.dao.UserDAO;
import iocexam.domain.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	@Override
	public void joinUser(User user) {
		System.out.println("user service joinUser 실행");
		userDAO.addUser(user);
	}
	
}
