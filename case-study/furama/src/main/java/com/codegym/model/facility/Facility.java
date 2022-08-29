package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private Integer facility_id;

    @Column(name = "facility_name")
    private String facility_name;

    private int area;

    private double cost;

    @Column(name = "max_people")
    private int max_people;

    @Column(name = "rent_type_id")
    private int rent_type_id;

    @Column(name = "facility_type_id")
    private int facility_type_id;

    @Column(name = "standard_room")
    private String standard_room;

    @Column(name = "description_other_convenience")
    private String description_other_convenience;

    @Column(name = "pool_area")
    private double pool_area;

    @Column(name = "number_of_floor")
    private int number_of_floor;

    @Column(name = "facility_free")
    private String facility_free;
}
