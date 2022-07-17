package br.ufrn.imd.moviesbackend.controller;

import br.ufrn.imd.moviesbackend.model.MovieDTO;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenceController {
    //Writes the MovieDTO to a json or appends if it already exists.
    public void writeMovie(MovieDTO movieDTO) {
        String path = "persistence/movies.json";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        //String movie =
    }

    //Reads the MovieDTO from a json or returns null if it doesn't exist.
    public MovieDTO readMovie() {
        //TODO
        return null;
    }
}
