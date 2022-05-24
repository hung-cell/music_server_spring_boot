package vn.assignment.music_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.assignment.music_server.dtos.Song;
import vn.assignment.music_server.entities.ArtistEntity;
import vn.assignment.music_server.entities.SongEntity;

import java.util.List;

public interface  ArtistRepository extends JpaRepository<ArtistEntity,Integer> {

}
