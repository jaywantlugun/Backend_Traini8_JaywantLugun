package com.jaywant.rest.traini8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaywant.rest.traini8.dto.TrainingCenterDTO;
import com.jaywant.rest.traini8.model.TrainingCenter;
import com.jaywant.rest.traini8.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
public class TrainingCenterController {

	@Autowired
	TrainingCenterService trainingCenterService;

	@GetMapping("/training-center-list") // url to get list
	public List<TrainingCenterDTO> getTrainingCenterList(
			@RequestParam(name = "min_capacity", required = false, defaultValue = "0") Integer min_capacity) {

		return trainingCenterService.getTrainingCenterDTOList(min_capacity);

	}

	@PostMapping("/training-center") // url to insert training center
	public ResponseEntity<?> addTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {

		// if validation fails custom Global exception class is called

		return trainingCenterService.addTrainingCenter(trainingCenter);

	}

}
