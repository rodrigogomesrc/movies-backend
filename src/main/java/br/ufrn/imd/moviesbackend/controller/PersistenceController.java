package br.ufrn.imd.moviesbackend.controller;

import br.ufrn.imd.moviesbackend.model.MovieDTO;
import br.ufrn.imd.moviesbackend.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PersistenceController {

    @Autowired
    private PersistenceService persistenceService;

    //writeMovie post request
    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO) {
        String response = "Error while adding movie";
        try {
            response = persistenceService.writeMovie(movieDTO);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(response);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<MovieDTO>> getMovies() {
        List<MovieDTO> movies = null;
        try {
            movies = persistenceService.readMovies();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(movies);
        }
        return ResponseEntity.ok().body(movies);
    }

}
