package com.example.repository;
import com.example.model.Month;
import java.util.List;

public interface IMonthRepository {
    List<Month> findAll();
}
