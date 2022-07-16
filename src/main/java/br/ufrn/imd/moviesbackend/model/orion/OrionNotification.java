package br.ufrn.imd.moviesbackend.model.orion;

import java.util.ArrayList;

public class OrionNotification {
    private ArrayList<String> attrs;
    private String attrsFormat;
    private OrionSubscriptionUrl http;

    public OrionNotification(ArrayList<String> attrs, String cygnusDockerEndpoint) {
        this.attrs = attrs;
        this.attrsFormat = "legacy";
        this.http = new OrionSubscriptionUrl(cygnusDockerEndpoint + "/notify");
    }

    public OrionNotification() {
    }

    public ArrayList<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(ArrayList<String> attrs) {
        this.attrs = attrs;
    }

    public String getAttrsFormat() {
        return attrsFormat;
    }

    public void setAttrsFormat(String attrsFormat) {
        this.attrsFormat = attrsFormat;
    }

    public OrionSubscriptionUrl getHttp() {
        return http;
    }

    public void setHttp(OrionSubscriptionUrl http) {
        this.http = http;
    }
}