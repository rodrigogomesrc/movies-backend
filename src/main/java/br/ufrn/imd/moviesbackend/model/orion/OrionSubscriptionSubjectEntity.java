package br.ufrn.imd.moviesbackend.model.orion;
public class OrionSubscriptionSubjectEntity {
    private String idPattern;
    private String type;

    public OrionSubscriptionSubjectEntity(String type) {
        this.idPattern = ".*";
        this.type = type;
    }

    public String getIdPattern() {
        return idPattern;
    }

    public void setIdPattern(String idPattern) {
        this.idPattern = idPattern;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
