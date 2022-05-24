package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "artistOFSong")
@Entity
@NoArgsConstructor
public class ArtistOfSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "songId",nullable = false)
    private SongEntity songEntity;

    @ManyToOne
    @JoinColumn(name = "artistId",nullable = false)
    private ArtistEntity artistEntity;

}
