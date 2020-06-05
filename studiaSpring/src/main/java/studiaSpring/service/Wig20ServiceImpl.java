package studiaSpring.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studiaSpring.dao.Wig20Repository;
import studiaSpring.entity.Wig20;

@Service
public class Wig20ServiceImpl implements Wig20Service{
	
private Wig20Repository wig20Repository;
	
	@Autowired
	public Wig20ServiceImpl(Wig20Repository wig20Repository) {
		this.wig20Repository = wig20Repository;
	}
	
	@Override
	public List<Wig20> findAll() {
		return wig20Repository.findAll();
	}

	@Override
	public Wig20 findById(Long theId) {
		Optional<Wig20> result = wig20Repository.findById(theId);
		
		Wig20 theWig20 = null;
		
		if (result.isPresent()) {
			theWig20 = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theWig20;
	}

	@Override
	public void save(Wig20 theWig20) {
		wig20Repository.save(theWig20);
	}

	@Override
	public void deleteById(Long theId) {
		wig20Repository.deleteById(theId);
	}

	@Override
	public void deleteAll() {
		wig20Repository.deleteAll();
		
	}

}
