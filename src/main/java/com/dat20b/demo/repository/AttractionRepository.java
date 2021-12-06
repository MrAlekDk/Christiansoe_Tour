package com.dat20b.demo.repository;

import com.dat20b.demo.model.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends CrudRepository<Attraction, Integer> {
}
