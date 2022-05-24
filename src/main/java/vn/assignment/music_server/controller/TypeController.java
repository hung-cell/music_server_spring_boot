package vn.assignment.music_server.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.assignment.music_server.dtos.Type;
import vn.assignment.music_server.service.TypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/types", produces = "application/json")
public class TypeController {

    private final TypeService typeService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Type> findAll(){
        return typeService.findALl();
    }


}
