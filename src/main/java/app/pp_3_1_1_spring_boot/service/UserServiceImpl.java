package app.pp_3_1_1_spring_boot.service;

import app.pp_3_1_1_spring_boot.dao.UserRepository;
import app.pp_3_1_1_spring_boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public void saveUser(User user) { userRepository.save(user); }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) { user = userOptional.get(); }
        return user;
    }

    @Override
    public void deleteUser(int id) { userRepository.deleteById(id); }

}