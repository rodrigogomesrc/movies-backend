package br.ufrn.imd.moviesbackend.service;

import br.ufrn.imd.moviesbackend.model.MovieDTO;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class PersistenceService {
    //Writes the MovieDTO to a json or appends if it already exists.
    public String writeMovie(MovieDTO movieDTO) throws IOException {
        String path = "persistence/movies.json";
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(path, true));
        Gson gson = new Gson();
        String movie = gson.toJson(movieDTO);
        writer.write(movie);
        writer.newLine();
        writer.close();
        return "Movie added successfully!";
    }

    //Reads the MovieDTOs from a json or returns null if it doesn't exist.
    public List<MovieDTO> readMovies() throws IOException {
        String path = "persistence/movies.json";
        Gson gson = new Gson();
        List<MovieDTO> movies = new ArrayList<>();
        Stream<String> inputStream = Files.lines(Paths.get(path), StandardCharsets.UTF_8);
        Consumer<String> consumer = line->{movies.add(gson.fromJson(line, MovieDTO.class));};
        inputStream.forEach(consumer);
        return movies;
    }
}
