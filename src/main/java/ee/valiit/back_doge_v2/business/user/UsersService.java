package ee.valiit.back_doge_v2.business.user;

import ee.valiit.back_doge_v2.business.user.dto.UserHomepageInfoResponse;
import ee.valiit.back_doge_v2.business.user.dto.UserInfoUpdate;
import ee.valiit.back_doge_v2.business.user.dto.UserPhotoRequest;
import ee.valiit.back_doge_v2.domain.user_role_information.user.User;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserMapper;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public UserHomepageInfoResponse getUserInfoByUserId(Integer userId) {
        User userById = getUserById(userId);
        return userMapper.userToHomepageResponse(userById);
    }

    public User getValidUserBy(String username, String password) {
        return userService.findValidUserBy(username, password);
    }

    public void addUserPhoto(UserPhotoRequest request) {
        User userBy = getUserById(request.getUserId());
        saveUserPhoto(userBy, request.getPhotoData());
    }

    private void saveUserPhoto(User userBy, String photoData) {
        byte[] bytes = photoData.getBytes(StandardCharsets.UTF_8);
        userBy.getContact().setPhotoData(bytes);
        userService.save(userBy);
    }

    public User getUserById(Integer userId) {
        return userService.findById(userId);
    }

    public void updateUserInfo(Integer userId, UserInfoUpdate request) {
        User user = userService.findById(userId);
        userMapper.updateUserInformation(request, user);
        userService.save(user);
    }
}
