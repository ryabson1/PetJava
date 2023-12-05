package ru.ryabson.Processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
