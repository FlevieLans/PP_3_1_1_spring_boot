package app.pp_3_2_1_spring_boot_security.service;

import app.pp_3_2_1_spring_boot_security.repository.RoleRepository;
import app.pp_3_2_1_spring_boot_security.repository.UserRepository;
import app.pp_3_2_1_spring_boot_security.entity.Role;
import app.pp_3_2_1_spring_boot_security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }


    public List<User> getAllUsers() { return userRepository.findAll(); }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) { return false; }
        user.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    public User getUser(int id) {
        Optional<User> userFromDB = userRepository.findById(id);
        return userFromDB.orElse(new User());
    }

    public boolean deleteUser(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) { throw new UsernameNotFoundException("User not found"); }
        return user;
    }

}