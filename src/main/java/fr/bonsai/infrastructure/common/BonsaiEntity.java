package fr.bonsai.infrastructure.common;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "bonsai")
@Table(name = "bonsais")
public class BonsaiEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "acquisition_date")
    private Date acquisition_date;

    @Column(name = "acquisition_age")
    private int acquisition_age;

    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity = WateringEntity.class, mappedBy = "bonsai")
    private List<WateringEntity> wateringEntityList;

    @OneToMany(targetEntity = RepottingEntity.class, mappedBy = "bonsai")
    private List<RepottingEntity> RepottingEntity;

    @OneToMany(targetEntity = PruningEntity.class,  mappedBy = "bonsai")
    private List<PruningEntity> PruningEntity;


    public BonsaiEntity() {
    }

    public List<WateringEntity> getWateringEntityList() {
        return wateringEntityList;
    }

    public void setWateringEntityList(List<WateringEntity> wateringEntityList) {
        this.wateringEntityList = wateringEntityList;
    }

    public List<fr.bonsai.infrastructure.common.RepottingEntity> getRepottingEntity() {
        return RepottingEntity;
    }

    public void setRepottingEntity(List<fr.bonsai.infrastructure.common.RepottingEntity> repottingEntity) {
        RepottingEntity = repottingEntity;
    }

    public List<fr.bonsai.infrastructure.common.PruningEntity> getPruningEntity() {
        return PruningEntity;
    }

    public void setPruningEntity(List<fr.bonsai.infrastructure.common.PruningEntity> pruningEntity) {
        PruningEntity = pruningEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}