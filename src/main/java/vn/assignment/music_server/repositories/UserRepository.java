package vn.assignment.music_server.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.assignment.music_server.entities.TypeEntity;
import vn.assignment.music_server.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity getUserEntityByUid(@Param("uid") String uid);
}
