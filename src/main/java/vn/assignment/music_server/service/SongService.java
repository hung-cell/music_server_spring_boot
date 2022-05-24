package vn.assignment.music_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.SongEntity;
import vn.assignment.music_server.repositories.SongRepositories;

import java.util.ArrayList;
import java.util.List;

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
                .song(songEntity.getSong())
                .url(songEntity.getUrl())
                .image(songEntity.getImage())
                .artist(artistName)
                .build();
    }
}
