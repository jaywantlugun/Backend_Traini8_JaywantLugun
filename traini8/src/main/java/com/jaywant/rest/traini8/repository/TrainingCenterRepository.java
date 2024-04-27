package com.jaywant.rest.traini8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaywant.rest.traini8.model.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, String> {

	TrainingCenter findByCenterCode(String centerCode); // custom query for filtering options via center code

}
