package iocexam.service;

import iocexam.dao.UserDAO;
import iocexam.domain.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
//	public UserServiceImpl() {}
	
	public UserServiceImpl(UserDAO userDAO) {
		System.out.println("생성자를 통한 userDAO 주입!!");
		this.userDAO = userDAO;
	}
	
	
	@Override
	public void joinUser(User user) {
		//회원 가입을 위한 비니지스적 처리가 필요하다면 여기서 구현..  
		System.out.println("UserService 의 joinUser 실행!! ");
		//회원의 정보를 저장하기 위해서 userDao 를 이용해서 DB에 저장!! 
		
		userDAO.addUser(user);
	}

}
