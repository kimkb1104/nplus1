package com.kimkb1104.nplus1.repository;

import com.kimkb1104.nplus1.entity.Album;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedHashSet;
import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a JOIN FETCH a.songs")
//    List<Album> findAllJoinFetch();
    LinkedHashSet<Album> findAllJoinFetch();

    @EntityGraph(attributePaths = "songs")
    @Query("SELECT a FROM Album a")
    LinkedHashSet<Album> findAllEntityGraph();
//    List<Album> findAllEntityGraph();

}
