package br.ufrn.imd.moviesbackend.model.orion;

public class MovieEntity {
    private String id;
    private EntityAttribute title;
    private EntityAttribute genre;
    private EntityAttribute exibitionDate;
    private EntityAttribute channel;
    private String type;

    public MovieEntity(String id, String title, String genre, String exibitionDate, String channel) {
        this.title = new EntityAttribute(title, "string");
        this.genre = new EntityAttribute(genre, "string");
        this.exibitionDate = new EntityAttribute(exibitionDate, "string");
        this.channel = new EntityAttribute(channel, "string");
        this.id = id;
        this.type = "Movie";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntityAttribute getTitle() {
        return title;
    }

    public void setTitle(EntityAttribute title) {
        this.title = title;
    }

    public EntityAttribute getGenre() {
        return genre;
    }

    public void setGenre(EntityAttribute genre) {
        this.genre = genre;
    }

    public EntityAttribute getExibitionDate() {
        return exibitionDate;
    }

    public void setExibitionDate(EntityAttribute exibitionDate) {
        this.exibitionDate = exibitionDate;
    }

    public EntityAttribute getChannel() {
        return channel;
    }

    public void setChannel(EntityAttribute channel) {
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
