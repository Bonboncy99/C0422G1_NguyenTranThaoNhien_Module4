package com.codegym.webmusic.service.impl;

import com.codegym.webmusic.model.Song;
import com.codegym.webmusic.repository.ISongRepository;
import com.codegym.webmusic.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        this.iSongRepository.save(song);
    }

    @Override
    public void update(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public void delete(int id) {
        this.iSongRepository.deleteById(id);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id).orElse(new Song());
    }
}
