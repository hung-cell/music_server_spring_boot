package vn.assignment.music_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.service.SongService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/songs", produces = "application/json")
public class SongController {

    private final SongService songService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Song> findAll(){
        return songService.findALl();
    }

    @GetMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> findByArtistId(@PathVariable int id){
        return songService.findByArtistId(id);
    }

    @GetMapping("/type/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> findByTypeId(@PathVariable int id){
        return songService.findByTypeId(id);
    }


    @GetMapping("/search/{key}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> findByTypeId(@PathVariable String key){
        return songService.searchSongByName(key);
    }


}
