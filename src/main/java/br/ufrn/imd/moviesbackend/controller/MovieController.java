package br.ufrn.imd.moviesbackend.controller;


import br.ufrn.imd.moviesbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

}
