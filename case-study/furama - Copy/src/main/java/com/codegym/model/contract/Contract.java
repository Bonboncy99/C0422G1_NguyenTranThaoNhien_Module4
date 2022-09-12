package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    private double deposit;
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facilityId", referencedColumnName = "facility_id")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private List<ContractDetail> contractDetailList;
}
