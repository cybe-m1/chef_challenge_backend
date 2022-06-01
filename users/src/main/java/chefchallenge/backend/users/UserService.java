package chefchallenge.backend.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(int id_user) {
        return userRepository.getById(id_user);
    }

    public User postConnexionUser(Connexion user) {
        var userWanted = userRepository.findByPseudo(user.getUsername());

        if(userWanted.getPassword().equals(user.getPassword())){
            return userWanted;
        } else {
            throw new IllegalArgumentException("Mauvais identifiant");
        }
    }

    public User addUser(User user) {
        if (userRepository.existsById(user.getId_user())) {
            throw new IllegalArgumentException("Id " + user.getId_user() + " already used");
        } else {
            return userRepository.save(user);
        }
    }

    public User modifyUser(User user) {
        if (userRepository.existsById(user.getId_user())) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Id: " + user.getId_user() + " not found");
        }
    }

    public String deleteUser(int id_user) {
        if (userRepository.existsById(id_user)) {
            User userToDelete = userRepository.getById(id_user);
            userRepository.delete(userToDelete);
            return "User deleted";
        } else {
            return "Id: " + id_user + " dosen't exist";
        }
    }
}
