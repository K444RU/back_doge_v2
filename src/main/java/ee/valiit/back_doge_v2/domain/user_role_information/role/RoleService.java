package ee.valiit.back_doge_v2.domain.user_role_information.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer roleId) {
        return roleRepository.findById(roleId);
    }
}