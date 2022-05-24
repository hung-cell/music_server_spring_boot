package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "albums")
@Entity
@NoArgsConstructor
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "albumId", referencedColumnName = "id")
    private List<SongEntity> listSong;
}
