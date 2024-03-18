package study.ToDoList.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.ToDoList.user.domain.User;
import study.ToDoList.user.domain.repository.UserRepository;
import study.ToDoList.user.president.dto.request.LoginRequest;
import study.ToDoList.user.president.dto.request.SignUpRequest;
import study.ToDoList.user.president.dto.response.SignUpResponse;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = User.createUser(
                signUpRequest.name(),
                signUpRequest.gender(),
                signUpRequest.birth(),
                signUpRequest.hometown(),
                signUpRequest.loginId(),
                signUpRequest.password()
        );

        userRepository.save(user);

        return new SignUpResponse(user.getUserInfoVO());
    }

    @Transactional
    public boolean login(LoginRequest loginRequest) {
        boolean result = userRepository.existsByLoginIdAndPassword(loginRequest.loginId(), loginRequest.password());

        return result;
    }
}
