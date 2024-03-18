package study.ToDoList.user.domain.vo;

import study.ToDoList.user.domain.Gender;
import study.ToDoList.user.domain.Hometown;

import java.time.LocalDate;

public record UserInfoVO(
        Long id,
        String name,
        Gender gender,
        LocalDate birth,
        Hometown hometown,
        String loginId,
        String password
) {
}
