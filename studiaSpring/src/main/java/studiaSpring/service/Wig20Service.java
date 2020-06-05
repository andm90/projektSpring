package studiaSpring.service;

import java.util.List;

import studiaSpring.entity.Wig20;


public interface Wig20Service {
	
	public List<Wig20> findAll();
	
	public Wig20 findById(Long theId);
	
	public void save(Wig20 theWig20);
	
	public void deleteById(Long theId);	
	
	public void deleteAll();
	
	
}
