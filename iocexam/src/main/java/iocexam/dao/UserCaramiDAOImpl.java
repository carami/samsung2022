package iocexam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import iocexam.domain.User;
@Repository("userCaramiDAO")
public class UserCaramiDAOImpl implements UserDAO {
	public UserCaramiDAOImpl() {
		System.out.println("userDAOcarami ");
	}
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
		System.out.println(user + "의 정보를 carami 잘 저장 되었습니다. ");
	}

}
