package vn.assignment.music_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.SongEntity;
import vn.assignment.music_server.repositories.SongRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongService {
    private final SongRepositories songRepositories;

    public List<Song> findALl(){
        List<SongEntity> list = songRepositories.findAll();
        List<Song> listSong = changeSongEntitiesToResponse(list);
        return listSong;
    }



    public List<Song> findByArtistId(int id){
        List<SongEntity> list = songRepositories.findSongByArtistId(id);
        List<Song> listSong = changeSongEntitiesToResponse(list);
        return listSong;
    }

    public List<Song> findByTypeId(int id){
        List<SongEntity> list = songRepositories.findSongByTypeId(id);
        List<Song> listSong = changeSongEntitiesToResponse(list);
        return listSong;
    }

    public List<Song> searchSongByName(String key){

        List<SongEntity> list = songRepositories.findSongEntitiesBySongContaining(key);
        if(list.size() == 0) list = songRepositories.findSongEntitiesByArtistName(key);
        List<Song> listSong = changeSongEntitiesToResponse(list);
        return listSong;
    }
    public List<Song> top10MostViewSong(){
        List<SongEntity> list =songRepositories.top10Song();

        return changeSongEntitiesToResponse( list);
    }
    private List<Song> changeSongEntitiesToResponse(List<SongEntity> list) {
        List<Song> listSong = new ArrayList<>();
        for (SongEntity s : list) {

            List<String> listArtistName = songRepositories.
                    findArtistNameBySongId(s.getId());
            Song sTemp = mapToSongModel(s, listArtistName);
            listSong.add(sTemp);
        }
        return listSong;
    }
    private Song mapToSongModel(SongEntity songEntity, List<String> listArtistName) {
        String artistName = "";
        for(String name : listArtistName){

            artistName += name + ", ";

        }
        if(!artistName.equals("")){
            StringBuffer sb= new StringBuffer(artistName);
            sb.deleteCharAt(sb.length()-2);
            artistName = sb.toString();
        }


        return Song.builder()
                .id(songEntity.getId())
                .song(songEntity.getSong())
                .url(songEntity.getUrl())
                .image(songEntity.getImage())
                .artist(artistName)
                .views(songEntity.getViews())
                .build();
    }

    public Song findById(int id) {
        Optional<SongEntity> s =songRepositories.findById(id);
        if(s.isPresent()){
            List<String> listArtistName = songRepositories.
                    findArtistNameBySongId(s.get().getId());
            Song sTemp = mapToSongModel(s.get(), listArtistName);
            return sTemp;
        }
        else  return null;
    }


}
