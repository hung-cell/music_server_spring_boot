package vn.assignment.music_server.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private int id;
    private String song;
    private String url;
    private String image;
    private String artist;
    private int views;
}
