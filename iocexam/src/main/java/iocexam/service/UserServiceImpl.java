package iocexam.service;

import iocexam.dao.UserDAO;
import iocexam.domain.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		System.out.println("생성자를 통한 userDAO주입");
		this.userDAO = userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		System.out.println("setter 메소드를 통한 userDAO 주입!!");
		this.userDAO = userDAO;
	}

	@Override
	public void joinUser(User user) {
		System.out.println("user service joinUser 실행");
		userDAO.addUser(user);
	}
	
}
