package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "typeOfSong")
@Entity
@NoArgsConstructor
public class TypeOfSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "songId",nullable = false)
    private SongEntity songEntity;

    @ManyToOne
    @JoinColumn(name = "typeId",nullable = false)
    private TypeEntity typeEntity;
}
