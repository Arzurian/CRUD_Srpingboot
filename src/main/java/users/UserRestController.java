package users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	// UserRepository userRepository;
	UserService userService;

	//Devolver todos los usuarios
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> listado = new ArrayList<User>();
		// listado = userRepository.findAll();
		listado = userService.findAll();
		return new ResponseEntity<>(listado, HttpStatus.OK);

	}

	//Devuelve un usuario buscado por id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User usuario = userService.findById(id);
//		if(usuario!=null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		
	}

	//Crear usuario
	//Se pasa por post un json con los datos name y birthDate, la id dejandola en blanco
	@PostMapping("/")
	public ResponseEntity<User> createNewUser(@RequestBody User user) {
		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//Borrar usuario por id
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id){
		User usuario = userService.findById(id);
		userService.delete(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//Acutalizar
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> updateUser(@PathVariable("id") int id, @RequestBody User user){
		userService.updateUser(id, user);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
