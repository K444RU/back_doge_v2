package ee.valiit.back_doge_v2.business.user;

import ee.valiit.back_doge_v2.business.user.dtos.OwnerPictureRequest;
import ee.valiit.back_doge_v2.business.user.dtos.OwnerHomepageInfoResponse;
import ee.valiit.back_doge_v2.business.user.services.UserService;
import ee.valiit.back_doge_v2.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tagastab user informatsiooni, kus sees on olemas kasutaia 'firstname', 'lastname', 'additionalInformation' ja 'roleType'"),
        @ApiResponse(responseCode = "403", description = "Valed kasutaja rekviisid. Ebaõnnestunud sisselogimine", content = @Content(schema = @Schema(implementation = ApiError.class)))
})
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/owner")
    @Operation(summary = "Get User Information by userId")
    public OwnerHomepageInfoResponse getUserInfoByUserId(@RequestParam Integer userId) {
        OwnerHomepageInfoResponse userInfoByUserId = userService.getUserInfoByUserId(userId);
        return userInfoByUserId;
    }

    @PostMapping("/photo")
    @Operation(summary = "Post user photo (save user photo)")
    public void adduserPhoto(@RequestBody OwnerPictureRequest userPhoto) {
        userService.addUserPhoto(userPhoto);
    }

}
