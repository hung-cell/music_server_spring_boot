package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "songs")
@Entity
@NoArgsConstructor
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String song;
    private String url;
    private String image;
    private String artist;
    private int views;

}
