package users;

import java.util.List;

//@Service
public interface UserService {
	//Buscar todos
	public List<User> findAll();

	//Buscar por id
	public User findById(int id);
	
	//Crear usuario
	public User save(User user);
	
	//Borrar usuario
	public User delete(User user);

	//Actualizar
	public User updateUser(int id, User user);
}
