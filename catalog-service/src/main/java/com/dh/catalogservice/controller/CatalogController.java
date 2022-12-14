package com.dh.catalogservice.controller;

import com.dh.catalogservice.api.model.movie.Movie;
import com.dh.catalogservice.api.service.MovieService;
import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final MovieService movieService;
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(MovieService movieService, CatalogService catalogService){
        this.movieService = movieService;
        this.catalogService = catalogService;
    }

    @GetMapping("/movies/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        return movieService.findMovieByGenre(genre);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(catalogService.findCatalogByGenre(genre));
    }
}
