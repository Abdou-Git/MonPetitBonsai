package fr.bonsai.domain.model;

import java.util.Date;
import java.util.UUID;

public class Repotting {

    private UUID id;

    private Date repotting_date;

    private Bonsai bonsai;

    public Repotting() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getRepotting_date() {
        return repotting_date;
    }

    public void setRepotting_date(Date pruning_date) {
        this.repotting_date = pruning_date;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }
}
