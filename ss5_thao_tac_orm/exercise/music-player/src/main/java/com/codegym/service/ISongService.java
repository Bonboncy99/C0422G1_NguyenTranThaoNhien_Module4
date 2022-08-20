package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void add(Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);
}
