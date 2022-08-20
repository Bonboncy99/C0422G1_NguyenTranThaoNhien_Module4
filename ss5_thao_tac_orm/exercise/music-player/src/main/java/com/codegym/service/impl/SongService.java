package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void add(Song song) {
        this.iSongRepository.add(song);
    }

    @Override
    public void update(Song song) {
        this.iSongRepository.update(song);
    }

    @Override
    public void delete(int id) {
        this.iSongRepository.delete(id);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id);
    }
}
