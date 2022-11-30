package ee.valiit.back_doge_v2.business.user;

import ee.valiit.back_doge_v2.business.user.services.UserService;
import ee.valiit.back_doge_v2.domain.user_role_information.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

//    @GetMapping("/owner")
//    @Operation(summary = "Get User Contact by userId")
//    List<UserDto> getUserContactByUserId(@RequestBody Integer userId) {
//        userService.getUserContactByUserId(userId);
//        return
//
//
//    }
}
