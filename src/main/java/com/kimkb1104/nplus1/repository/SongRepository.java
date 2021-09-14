package com.kimkb1104.nplus1.repository;

import com.kimkb1104.nplus1.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
