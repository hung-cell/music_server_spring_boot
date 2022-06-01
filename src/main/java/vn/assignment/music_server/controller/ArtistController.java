package vn.assignment.music_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.assignment.music_server.dtos.Artist;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.service.ArtistService;
import vn.assignment.music_server.service.SongService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/artists", produces = "application/json")
public class ArtistController {

    private final ArtistService artistService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)

    public List<Artist> findAll(){
        return artistService.findALl();
    }
}
