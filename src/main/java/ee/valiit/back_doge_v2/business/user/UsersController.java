package ee.valiit.back_doge_v2.business.user;

import ee.valiit.back_doge_v2.business.user.dto.UserHomepageInfoResponse;
import ee.valiit.back_doge_v2.business.user.dto.UserInfoUpdate;
import ee.valiit.back_doge_v2.business.user.dto.UserPhotoRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
//@ApiResponses(value = {
//        @ApiResponse(responseCode = "200", description = "Tagastab user informatsiooni, kus sees on olemas kasutaia 'firstname', 'lastname', 'additionalInformation' ja 'roleType'"),
//        @ApiResponse(responseCode = "403", description = "Valed kasutaja rekviisid. Ebaõnnestunud sisselogimine", content = @Content(schema = @Schema(implementation = ApiError.class)))
//})
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/info")
    @Operation(summary = "Get User Information by userId")
    public UserHomepageInfoResponse getUserInfoByUserId(@RequestParam Integer userId) {
        UserHomepageInfoResponse userInfoByUserId = usersService.getUserInfoByUserId(userId);
        return userInfoByUserId;
    }

    @PostMapping("/photo")
    @Operation(summary = "Post user photo (save user photo)")
    public void adduserPhoto(@RequestBody UserPhotoRequest userPhoto) {
        usersService.addUserPhoto(userPhoto);
    }

    @PutMapping()
    @Operation(summary = "Update user information")
    public void updateUserInfo(@RequestParam Integer userId, @RequestBody UserInfoUpdate request){
        usersService.updateUserInfo(userId, request);
    }
}
