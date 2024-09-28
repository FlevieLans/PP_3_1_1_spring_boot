package app.pp_3_2_1_spring_boot_security.repository;

import app.pp_3_2_1_spring_boot_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
