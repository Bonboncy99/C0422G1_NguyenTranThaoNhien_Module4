package com.codegym.model.customer;

import com.codegym.model.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer customerTypeId;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customerSet;
    @Column(name = "customer_type_name")
    private String customerTypeName;

//    public CustomerType() {
//    }
//
//    public CustomerType(Integer customerTypeId, String customerTypeName) {
//        this.customerTypeId = customerTypeId;
//        this.customerTypeName = customerTypeName;
//    }
//
//    public Set<Customer> getCustomerSet() {
//        return customerSet;
//    }
//
//    public void setCustomerSet(Set<Customer> customerSet) {
//        this.customerSet = customerSet;
//    }
//
//    public Integer getCustomerTypeId() {
//        return customerTypeId;
//    }
//
//    public void setCustomerTypeId(Integer customerTypeId) {
//        this.customerTypeId = customerTypeId;
//    }
//
//    public String getCustomerTypeName() {
//        return customerTypeName;
//    }
//
//    public void setCustomerTypeName(String customerTypeName) {
//        this.customerTypeName = customerTypeName;
//    }
}
