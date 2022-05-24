package vn.assignment.music_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.SongEntity;

import java.util.List;

public interface SongRepositories extends JpaRepository<SongEntity,Long> {
    @Query( "SELECT a.name FROM ArtistEntity a " +
            "INNER JOIN ArtistOfSong aos ON a.id = aos.artistEntity.id " +
            "INNER JOIN SongEntity s ON s.id = aos.songEntity.id " +
            "WHERE s.id = ?1 ")
    List<String> findArtistNameBySongId(int id);



    @Query( "SELECT s FROM SongEntity s " +
            "INNER JOIN ArtistOfSong aos ON s.id = aos.songEntity.id " +
            "INNER JOIN ArtistEntity a ON a.id = aos.artistEntity.id " +
            "WHERE a.id = ?1 ")
    List<SongEntity> findSongByArtistId(int artistId);

    @Query( "SELECT s FROM SongEntity s " +
            "INNER JOIN TypeOfSong aos ON s.id = aos.songEntity.id " +
            "INNER JOIN TypeEntity t ON t.id = aos.typeEntity.id " +
            "WHERE t.id = ?1 ")
    List<SongEntity> findSongByTypeId(int typeId);

    List<SongEntity> findSongEntitiesBySongContaining(String name);

    @Query( "SELECT s FROM SongEntity s " +
            "INNER JOIN ArtistOfSong aos ON s.id = aos.songEntity.id " +
            "INNER JOIN ArtistEntity a ON a.id = aos.artistEntity.id " +
            "WHERE a.name LIKE  %:key% ")
    List<SongEntity> findSongEntitiesByArtistName(String key);

}
