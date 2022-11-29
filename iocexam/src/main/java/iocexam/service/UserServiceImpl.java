package iocexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import iocexam.dao.UserDAO;
import iocexam.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userCaramiDAO")
	private UserDAO userDAO;
	
//	@Autowired
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	

	@Override
	public void joinUser(User user) {
		// 회원가입에 필요한 비지니스가 있다면 여기에 구현!!!! 
		System.out.println("user service joinUser 실행");
		userDAO.addUser(user);
		
	}

}
