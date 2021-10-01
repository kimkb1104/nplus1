package com.kimkb1104.nplus1.repository;

import com.kimkb1104.nplus1.entity.Album;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Test
    @DisplayName("Problem 1) FetchType.EAGER")
    void problem1() {
        List<Album> albums = albumRepository.findAll();

        assertThat(albums.size() == 3).isTrue();
    }

    @Test
    @DisplayName("Problem 2) FetchType.LAZY")
    void problem2() {
        List<Album> albums = albumRepository.findAll();
        for (Album album : albums) {
            System.out.print("album : " + album.getId());
            System.out.println(", size : " + album.getSongs().size());
        }

        assertThat(albums.size() == 3).isTrue();
    }

    @Test
    @DisplayName("Solution 1) Use Join Fetch")
    void solution1() {
        Collection<Album> albums = albumRepository.findAllJoinFetch();
        for (Album album : albums) {
            System.out.print("album : " + album.getId());
            System.out.println(", size : " + album.getSongs().size());
        }

        assertThat(albums.size() == 3).isTrue();
    }

    @Test
    @DisplayName("Solution 2) Use @EntityGraph")
    void solution2() {
        Collection<Album> albums = albumRepository.findAllEntityGraph();
        for (Album album : albums) {
            System.out.print("album : " + album.getId());
            System.out.println(", size : " + album.getSongs().size());
        }

        assertThat(albums.size() == 3).isTrue();
    }

}
