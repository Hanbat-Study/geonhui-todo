package study.ToDoList.user.president.dto.request;

import study.ToDoList.user.domain.Gender;
import study.ToDoList.user.domain.Hometown;

import java.time.LocalDate;

public record SignUpRequest(
        String name,
        Gender gender,
        LocalDate birth,
        Hometown hometown,
        String loginId,
        String password
) {
}
