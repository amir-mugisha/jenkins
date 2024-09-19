package com.jkns.jenkins.controller;

import com.jkns.jenkins.dto.MovieDto;
import com.jkns.jenkins.model.Movie;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Dummy Movie 1", "Action", 2019));
        movies.add(new Movie(2, "Dummy Movie 2", "Anime", 2019));
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody MovieDto movieDto) {
        Movie dummyMovie = new Movie(3, movieDto.getName(), movieDto.getGenre(), movieDto.getYear());
        return ResponseEntity.status(HttpStatus.CREATED).body(dummyMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie dummyMovie = new Movie(id, "Dummy Movie " + id, "Comedy" + id, 2019);
        return ResponseEntity.ok(dummyMovie);
    }
}