package com.codegym.webmusic.repository;

import com.codegym.webmusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository  extends JpaRepository<Song,Integer> {

}
