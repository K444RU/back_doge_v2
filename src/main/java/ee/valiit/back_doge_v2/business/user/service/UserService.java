package ee.valiit.back_doge_v2.business.user.service;

import ee.valiit.back_doge_v2.business.user.dto.OwnerHomepageInfoResponse;
import ee.valiit.back_doge_v2.business.user.dto.OwnerPictureRequest;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserRepository;
import ee.valiit.back_doge_v2.errors.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    public OwnerHomepageInfoResponse getUserInfoByUserId(Integer userId) {
        User userById = getUserById(userId);
        return userMapper.userToHomepageResponse(userById);

    }

    public User getValidUserByNameAndPassword(String username, String password) {
        Optional<User> userLogin = userRepository.findBy(username, password);
        Validation.validationUser(userLogin);
        return userLogin.get();
    }

    public void addUserPhoto(OwnerPictureRequest request) {
        User userBy = getUserBy(request.getUserId());
        saveUserPhoto(userBy, request.getPhotoData());
    }

    public User getUserBy(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();

    }

    private void saveUserPhoto(User userBy, String photoData) {
        byte[] bytes = photoData.getBytes(StandardCharsets.UTF_8);
        userBy.getContact().setPhotoData(bytes);
        userRepository.save(userBy);

    }

    public User getUserById(Integer userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }
}
