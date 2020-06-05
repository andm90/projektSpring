package studiaSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studiaSpring.dao.AuthorityRepository;
import studiaSpring.entity.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	private AuthorityRepository authorityRepository;
	
	@Autowired
	public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	@Override
	public List<Authority> findAll() {
		return authorityRepository.findAll();
	}

	@Override
	public Authority findById(Long theId) {
		Optional<Authority> result = authorityRepository.findById(theId);
		
		Authority theAuthority = null;
		
		if (result.isPresent()) {
			theAuthority = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find authority id - " + theId);
		}
		
		return theAuthority;
	}

	@Override
	public void save(Authority theAuthority) {
		authorityRepository.save(theAuthority);
	}

	@Override
	public void deleteById(Long theId) {
		authorityRepository.deleteById(theId);
	}

}
