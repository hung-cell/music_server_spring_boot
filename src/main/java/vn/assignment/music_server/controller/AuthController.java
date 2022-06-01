package vn.assignment.music_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.assignment.music_server.entities.UserEntity;
import vn.assignment.music_server.repositories.UserRepository;
import vn.assignment.music_server.service.ArtistService;
import vn.assignment.music_server.service.UserService;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/register", produces = "application/json")
public class AuthController {
    private final UserService userService;
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return userEntity;
    }

}
