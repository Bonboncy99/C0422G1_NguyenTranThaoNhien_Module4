package com.codegym.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private Integer facilityId;

    @Column(name = "facility_name")
    private String facilityName;

    private int area;

    private double cost;

    @Column(name = "max_people")
    private int maxPeople;


    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @Column(name = "standard_room")
    private String standardRoom;

    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    private String poolArea;

    @Column(name = "number_of_floor")
    private String numberOfFloor;

    @Column(name = "facility_free")
    private String facilityFree;

}

