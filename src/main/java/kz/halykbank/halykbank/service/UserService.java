package kz.halykbank.halykbank.service;

import kz.halykbank.halykbank.dto.UserDTO;
import kz.halykbank.halykbank.mapper.UserMapper;
import kz.halykbank.halykbank.model.User;
import kz.halykbank.halykbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<UserDTO> getList() {
        return userMapper.toDTOList(userRepository.findAll());
    }
}
