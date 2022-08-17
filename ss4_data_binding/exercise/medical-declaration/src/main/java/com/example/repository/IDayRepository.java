package com.example.repository;
import com.example.model.Day;
import java.util.List;

public interface IDayRepository {
    List<Day> findAll();
}
