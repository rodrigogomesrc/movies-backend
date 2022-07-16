package br.ufrn.imd.moviesbackend.model.orion;

import java.util.ArrayList;

public class OrionSubscriptionSubject {
    private ArrayList<OrionSubscriptionSubjectEntity> entities;
    private OrionSubscriptionSubjectCondition condition;

    public OrionSubscriptionSubject(String pattern, ArrayList<String> attrs) {
        ArrayList<OrionSubscriptionSubjectEntity> entities = new ArrayList<OrionSubscriptionSubjectEntity>();
        entities.add(new OrionSubscriptionSubjectEntity(pattern));
        this.entities = entities;
        this.condition = new OrionSubscriptionSubjectCondition(attrs);
    }

    public OrionSubscriptionSubject() {
    }

    public ArrayList<OrionSubscriptionSubjectEntity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<OrionSubscriptionSubjectEntity> entities) {
        this.entities = entities;
    }

    public OrionSubscriptionSubjectCondition getCondition() {
        return condition;
    }

    public void setCondition(OrionSubscriptionSubjectCondition condition) {
        this.condition = condition;
    }
}

