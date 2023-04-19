package users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll();

	public User findUserById(int id);
	
	public User save(User user);
	
	public void delete(User user);
	

}
