package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@Table(name = "playlist")
@Entity
@NoArgsConstructor
public class PlayListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "playlistId", referencedColumnName = "id",nullable = true)
    private List<SongEntity> listSong;
}
