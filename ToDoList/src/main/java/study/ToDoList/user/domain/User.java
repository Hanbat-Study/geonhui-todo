package study.ToDoList.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.ToDoList.user.domain.vo.UserInfoVO;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Enumerated(STRING)
    private Gender gender;
    private LocalDate birth;

    @Enumerated(STRING)
    private Hometown hometown;
    private String loginId;
    private String password;

    @Builder
    public User(String name, Gender gender, LocalDate birth, Hometown hometown, String loginId, String password) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.hometown = hometown;
        this.loginId = loginId;
        this.password = password;
    }

    public static User createUser(String name, Gender gender, LocalDate birth, Hometown hometown, String loginId, String password) {
        return builder()
                .name(name)
                .gender(gender)
                .birth(birth)
                .hometown(hometown)
                .loginId(loginId)
                .password(password)
                .build();
    }

    public UserInfoVO getUserInfoVO() {
        return new UserInfoVO(
                id,
                name,
                gender,
                birth,
                hometown,
                loginId,
                password
        );
    }
}
