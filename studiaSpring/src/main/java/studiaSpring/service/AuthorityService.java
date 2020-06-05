package studiaSpring.service;

import java.util.List;

import studiaSpring.entity.Authority;


public interface AuthorityService {
	
	public List<Authority> findAll();
	
	public Authority findById(Long theId);
	
	public void save(Authority theAuthority);
	
	public void deleteById(Long theId);

}
