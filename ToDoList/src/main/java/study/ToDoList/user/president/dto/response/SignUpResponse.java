package study.ToDoList.user.president.dto.response;

import study.ToDoList.user.domain.Gender;
import study.ToDoList.user.domain.Hometown;
import study.ToDoList.user.domain.vo.UserInfoVO;

import java.time.LocalDate;

public record SignUpResponse(
        String name,
        Gender gender,
        LocalDate birth,
        Hometown hometown,
        String loginId,
        String password
) {
    public SignUpResponse(UserInfoVO userInfoVO) {
        this(userInfoVO.name(), userInfoVO.gender(), userInfoVO.birth(), userInfoVO.hometown(), userInfoVO.loginId(), userInfoVO.password());
    }
}
