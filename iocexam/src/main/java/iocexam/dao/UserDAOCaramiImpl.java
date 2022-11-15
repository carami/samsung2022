package iocexam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import iocexam.domain.User;
@Repository("userDAOCarami")
public class UserDAOCaramiImpl implements UserDAO {

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		System.out.println(user + "를 carami가 잘 저장했습니다.");

	}

}
