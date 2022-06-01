package vn.assignment.music_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.assignment.music_server.dtos.Artist;
import vn.assignment.music_server.dtos.Type;
import vn.assignment.music_server.entities.ArtistEntity;
import vn.assignment.music_server.entities.TypeEntity;
import vn.assignment.music_server.repositories.ArtistRepository;
import vn.assignment.music_server.repositories.TypeRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class TypeService {
    private final TypeRepository typeRepository;

    public List<Type> findALl(){
        List<TypeEntity> list = typeRepository.findAll();
        List<Type> ListType = new ArrayList<>();
        for(TypeEntity t : list){


            Type tTemp = mapToTypeModel(t);
            ListType.add(tTemp);
        }
        return ListType;
    }



    private Type mapToTypeModel(TypeEntity typeEntity) {
        return Type.builder()
                .id(typeEntity.getId())
                .name(typeEntity.getName())
                .image(typeEntity.getImage())
                .build();
    }
}
