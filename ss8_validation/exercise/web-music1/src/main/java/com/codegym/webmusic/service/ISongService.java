package com.codegym.webmusic.service;

import com.codegym.webmusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song>findAll();
    void add(Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);

}
