package vn.assignment.music_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.assignment.music_server.dtos.UserResponse;
import vn.assignment.music_server.entities.UserEntity;
import vn.assignment.music_server.repositories.TypeRepository;
import vn.assignment.music_server.repositories.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void save(UserEntity userEntity){

        userRepository.save(userEntity);
    }
}
