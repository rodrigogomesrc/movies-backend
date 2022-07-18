package br.ufrn.imd.moviesbackend.model;

public class SubscriptionDTO {
    String user;
    String genre;

    public SubscriptionDTO(String user, String genre) {
        this.genre = genre;
        this.user = user;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
