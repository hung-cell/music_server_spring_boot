package vn.assignment.music_server.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "favorites")
@Entity
@NoArgsConstructor
public class FavoritesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isFavorite;
    private int listensFrequency;
    private boolean isDownLoad = false;

    @ManyToOne
    @JoinColumn(name = "songId",nullable = false)
    private SongEntity songEntity;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity userEntity;
}
