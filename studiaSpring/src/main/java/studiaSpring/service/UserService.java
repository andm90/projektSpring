package studiaSpring.service;

import java.util.List;

import studiaSpring.entity.User;


public interface UserService {
	
	public List<User> findAll();
	
	public User findById(Long theId);
	
	public void save(User theUser);
	
	public void deleteById(Long theId);

}
