package br.ufrn.imd.moviesbackend.controller;


import br.ufrn.imd.moviesbackend.model.SubscriptionDTO;
import br.ufrn.imd.moviesbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    //Subscribe to a genre
    @PostMapping("/subscribeToGenre")
    public ResponseEntity<String> subscribeToGenre(@RequestBody SubscriptionDTO subscriptionDTO) {
        String response = movieService.subscribeToGenre(subscriptionDTO);
        return ResponseEntity.ok().body(response);
    }
    //Unsubscribe from a genre
    @PostMapping("/unsubscribeFromGenre")
    public ResponseEntity<String> unsubscribeFromGenre(@RequestBody SubscriptionDTO subscriptionDTO) {
        String response = movieService.unsubscribeFromGenre(subscriptionDTO);
        return ResponseEntity.ok().body(response);
    }
}
