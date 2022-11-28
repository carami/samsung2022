package iocexam.service;

import iocexam.dao.UserDAO;
import iocexam.domain.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	

	@Override
	public void joinUser(User user) {
		// 회원가입에 필요한 비지니스가 있다면 여기에 구현!!!! 
		System.out.println("user service joinUser 실행");
		
	}

}
