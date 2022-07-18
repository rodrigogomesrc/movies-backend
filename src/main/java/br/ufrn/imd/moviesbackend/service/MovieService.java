package br.ufrn.imd.moviesbackend.service;

import br.ufrn.imd.moviesbackend.model.SubscriptionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    HashMap<String, List<String>> genresAndUsersSubscribed;
    HashMap<String, List<String>> usersAndPendingNotifications;

    public MovieService() {
        this.genresAndUsersSubscribed = new HashMap<>();
        this.usersAndPendingNotifications = new HashMap<>();
    }
    //Subscribe to a genre
    public String subscribeToGenre(SubscriptionDTO subscriptionDTO) {
        if(!genresAndUsersSubscribed.containsKey(subscriptionDTO.getGenre())) {
            genresAndUsersSubscribed.put(subscriptionDTO.getGenre(), new ArrayList<>());
        }
        if(!genresAndUsersSubscribed.get(subscriptionDTO.getGenre()).contains(subscriptionDTO.getUser())) {
            genresAndUsersSubscribed.get(subscriptionDTO.getGenre()).add(subscriptionDTO.getUser());
            return "Subscribed to genre " + subscriptionDTO.getGenre();
        }
        return "You are already subscribed to genre " + subscriptionDTO.getGenre();
    }
    //Unsubscribe from a genre
    public String unsubscribeFromGenre(SubscriptionDTO subscriptionDTO) {
        if(genresAndUsersSubscribed.containsKey(subscriptionDTO.getGenre())) {
            if(genresAndUsersSubscribed.get(subscriptionDTO.getGenre()).contains(subscriptionDTO.getUser())) {
                genresAndUsersSubscribed.get(subscriptionDTO.getGenre()).remove(subscriptionDTO.getUser());
                return "Unsubscribed from genre " + subscriptionDTO.getGenre();
            }
        }
        return "You are not subscribed to genre " + subscriptionDTO.getGenre();
    }

}
