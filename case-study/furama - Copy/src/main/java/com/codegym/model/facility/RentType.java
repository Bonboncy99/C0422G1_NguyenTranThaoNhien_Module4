package com.codegym.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;
    @Column(name = "rent_type_name")
    private String rentTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilitySet;
    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }
}
