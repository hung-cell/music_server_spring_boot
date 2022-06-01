package vn.assignment.music_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.SongEntity;
import vn.assignment.music_server.repositories.SongRepositories;
import vn.assignment.music_server.repositories.UserRepository;
import vn.assignment.music_server.service.SongService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/songs", produces = "application/json")
public class SongController {
    @Autowired
    private SongRepositories songRepositories;

    @Autowired
    private UserRepository userRepository;
    private final SongService songService;

    @GetMapping
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

    @PutMapping("/view/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void increaseView(@PathVariable int id){
         Optional<SongEntity> s= songRepositories.findById(id);
        if(s.isPresent()){
            int view = s.get().getViews();
            int viewPlus = view += 1;
            s.get().setViews(viewPlus);
            songRepositories.save(s.get());
        }


    }


}
