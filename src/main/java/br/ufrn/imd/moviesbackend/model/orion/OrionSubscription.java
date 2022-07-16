package br.ufrn.imd.moviesbackend.model.orion;

import java.util.ArrayList;

public class OrionSubscription {

    private String description;
    private OrionSubscriptionSubject subject;
    private OrionNotification notification;

    public OrionSubscription(String description, String pattern, ArrayList<String> attrs, String cygnusDockerEndpoint) {
        this.description = description;
        this.subject = new OrionSubscriptionSubject(pattern, attrs);
        this.notification = new OrionNotification(attrs, cygnusDockerEndpoint);
    }

    public OrionSubscription() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrionSubscriptionSubject getSubject() {
        return subject;
    }

    public void setSubject(OrionSubscriptionSubject subject) {
        this.subject = subject;
    }

    public OrionNotification getNotification() {
        return notification;
    }

    public void setNotification(OrionNotification notification) {
        this.notification = notification;
    }
}
