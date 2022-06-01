package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users")
@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String image;
    private String uid;

    public UserEntity(String email, String uid) {
        this.email = email;
        this.uid = uid;
    }

}
