package app.pp_3_2_1_spring_boot_security.repository;

import app.pp_3_2_1_spring_boot_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
