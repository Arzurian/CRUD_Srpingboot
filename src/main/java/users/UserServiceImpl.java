package users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> usuario = userRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

	@Override
	public User save(User user) {
		User usuario = userRepository.save(user);

		return usuario;
	}

	@Override
	public User delete(User user) {
		userRepository.delete(user);

		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		//user es la informacion del put. Se le pon la ID y se actualiza ese registro
		user.setId(id);
		userRepository.save(user);
		return user;

	}
}
