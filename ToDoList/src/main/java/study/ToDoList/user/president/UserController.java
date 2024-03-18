package study.ToDoList.user.president;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.ToDoList.response.DefaultRes;
import study.ToDoList.response.StatusCode;
import study.ToDoList.user.president.dto.request.LoginRequest;
import study.ToDoList.user.president.dto.request.SignUpRequest;
import study.ToDoList.user.president.dto.response.SignUpResponse;
import study.ToDoList.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = userService.signUp(signUpRequest);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료", signUpResponse), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody LoginRequest loginRequest) {
        boolean result = userService.login(loginRequest);

        return result ?
            new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 완료", result), HttpStatus.OK):
            new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "로그인 실패"), HttpStatus.OK);
    }
}
