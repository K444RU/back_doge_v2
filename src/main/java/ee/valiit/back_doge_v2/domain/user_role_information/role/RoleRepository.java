package ee.valiit.back_doge_v2.domain.user_role_information.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByType(String type);

    Role getByType(String type);




}