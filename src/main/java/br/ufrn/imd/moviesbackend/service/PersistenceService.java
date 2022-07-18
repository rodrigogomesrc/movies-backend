package br.ufrn.imd.moviesbackend.service;

import br.ufrn.imd.moviesbackend.model.MovieDTO;
import br.ufrn.imd.moviesbackend.model.orion.MovieEntity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

@Service
public class PersistenceService {

    @Value("${application.fiware.orion.host}")
    public String orionHost;

    @Value("${application.fiware.orion.port}")
    public String orionPort;

    //Writes the MovieDTO to a json or appends if it already exists.
    public String writeMovie(MovieDTO movieDTO) throws IOException {

        MovieEntity movieEntity = new MovieEntity(
                movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getGenre(),
                movieDTO.getExibitionDate(),
                movieDTO.getChannel()
        );
        FiwareService.createEntity(movieEntity, orionHost, orionPort);

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
