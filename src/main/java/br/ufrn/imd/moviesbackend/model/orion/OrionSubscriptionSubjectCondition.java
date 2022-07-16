package br.ufrn.imd.moviesbackend.model.orion;

import java.util.ArrayList;

public class OrionSubscriptionSubjectCondition {
    private ArrayList<String> attrs;

    public OrionSubscriptionSubjectCondition(ArrayList<String> attrs) {
        this.attrs = attrs;
    }

    public OrionSubscriptionSubjectCondition() {
    }

    public ArrayList<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(ArrayList<String> attrs) {
        this.attrs = attrs;
    }
}
