package study.ToDoList.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ToDoList.user.domain.User;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginIdAndPassword(String loginId, String password);

}
