package com.codegym.repository;

import com.codegym.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone,Integer> {
}
