package vn.assignment.music_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.assignment.music_server.entities.SongEntity;
import vn.assignment.music_server.entities.TypeEntity;

public interface TypeRepository  extends JpaRepository<TypeEntity,Long> {
}
