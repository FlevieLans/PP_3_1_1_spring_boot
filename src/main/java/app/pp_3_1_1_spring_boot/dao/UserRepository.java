package app.pp_3_1_1_spring_boot.dao;

import app.pp_3_1_1_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
