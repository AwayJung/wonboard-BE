package kr.re.mydata.wonboard.controller.v2;

import jakarta.validation.Valid;
import kr.re.mydata.wonboard.common.constant.ApiRespPolicy;
import kr.re.mydata.wonboard.common.model.response.ApiV2Resp;
import kr.re.mydata.wonboard.model.request.v2.UserV2Req;
import kr.re.mydata.wonboard.model.response.v2.UserV2Resp;
import kr.re.mydata.wonboard.service.v2.UserV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v2/users")
public class UserV2Controller {

    @Autowired
    private UserV2Service userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiV2Resp> signup(@RequestBody @Valid UserV2Req userReq) throws Exception  {
        userService.createUser(userReq);
        return ResponseEntity.status(ApiRespPolicy.SUCCESS_CREATED.getHttpStatus()).body(ApiV2Resp.of(ApiRespPolicy.SUCCESS_CREATED));
    }

    // Example: Return Response body
    @PostMapping("/signup-example")
    public ResponseEntity<ApiV2Resp> signupAndReturnResponseBody(@RequestBody @Valid UserV2Req userReq) throws Exception  {
        UserV2Resp result = userService.createUserAndReturnResponseBody(userReq);
        return ResponseEntity.status(ApiRespPolicy.SUCCESS_CREATED.getHttpStatus()).body(ApiV2Resp.of(ApiRespPolicy.SUCCESS_CREATED, result));
    }

}