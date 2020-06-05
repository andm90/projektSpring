package studiaSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import studiaSpring.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
