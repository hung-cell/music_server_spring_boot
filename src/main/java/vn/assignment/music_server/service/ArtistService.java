package vn.assignment.music_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.assignment.music_server.dtos.Artist;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.ArtistEntity;
import vn.assignment.music_server.entities.SongEntity;
import vn.assignment.music_server.repositories.ArtistRepository;
import vn.assignment.music_server.repositories.SongRepositories;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<Artist> findALl(){
        List<ArtistEntity> list = artistRepository.findAll();
        List<Artist> listArtist = new ArrayList<>();
        for(ArtistEntity a : list){


            Artist aTemp = mapToArtistModel(a);
            listArtist.add(aTemp);
        }
        return listArtist;
    }



    private Artist mapToArtistModel(ArtistEntity artistEntity) {
        return Artist.builder()
                .name(artistEntity.getName())
                .description(artistEntity.getDescription())
                .image(artistEntity.getImage())

                .build();
    }
}
