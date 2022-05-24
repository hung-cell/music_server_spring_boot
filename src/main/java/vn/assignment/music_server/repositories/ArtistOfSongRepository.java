package vn.assignment.music_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.assignment.music_server.entities.SongEntity;

public interface ArtistOfSongRepository extends JpaRepository<SongEntity,Long> {

}
