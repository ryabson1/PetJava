package ru.ryabson.Processing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryabson.Processing.entity.User;
import ru.ryabson.Processing.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public boolean checkLoginAvailable(String userName) {
        return userRepository.findByUserName(userName) != null;
    }

}
