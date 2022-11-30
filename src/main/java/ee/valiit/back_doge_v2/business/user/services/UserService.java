package ee.valiit.back_doge_v2.business.user.services;

import ee.valiit.back_doge_v2.business.user.dtos.OwnerPictureRequest;
import ee.valiit.back_doge_v2.business.user.dtos.OwnerHomepageInfoResponse;
import ee.valiit.back_doge_v2.domain.dog_information.dog.Dog;
import ee.valiit.back_doge_v2.domain.dog_information.dog.DogRepository;
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
        OwnerHomepageInfoResponse ownerHomepageInfoResponse = userMapper.userToHomepageResponse(userById);
        return ownerHomepageInfoResponse;
    }

    public User getUserById(Integer userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return user;
    }

    public User getValidUserByNameAndPassword(String username, String password) {
        Optional<User> userLogin = userRepository.findBy(username, password);
        Validation.validationUser(userLogin);
        User result = userLogin.get();
        return result;
    }


    public void addUserPhoto(OwnerPictureRequest request) {
        User userBy = getUserBy(request.getUserId());
        saveUserPhoto(userBy, request.getPhotoData());
    }


    public User getUserBy(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return user;

    }

    private void saveUserPhoto(User userBy, String photoData) {
        byte[] bytes = photoData.getBytes(StandardCharsets.UTF_8);
        userBy.getContact().setPhotoData(bytes);
        userRepository.save(userBy);

    }


}
