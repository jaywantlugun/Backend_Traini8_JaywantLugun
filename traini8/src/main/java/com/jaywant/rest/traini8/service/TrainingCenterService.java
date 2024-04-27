package com.jaywant.rest.traini8.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaywant.rest.traini8.dto.TrainingCenterDTO;
import com.jaywant.rest.traini8.model.TrainingCenter;
import com.jaywant.rest.traini8.repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {

	@Autowired
	TrainingCenterRepository trainingCenterRepository; // instance to interact with database

	@Autowired
	private ModelMapper modelMapper;

	public List<TrainingCenterDTO> getTrainingCenterDTOList(Integer min_capacity) {

		if (min_capacity == null || min_capacity == 0)
			return trainingCenterRepository.findAll().stream().map(this::convertEntityToDto)
					.collect(Collectors.toList());
		; // default return if no filtering query is passed on url

		return trainingCenterRepository.findAll().stream() // custom filtering list according to capacity
				.filter(arr -> arr.getCapacity() >= min_capacity).map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	public ResponseEntity<?> addTrainingCenter(TrainingCenter trainingCenter) {
		try {

			// checking if training center with center code is already present or not
			if (trainingCenterRepository.findByCenterCode(trainingCenter.getCenterCode()) != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Entry with center code = " + trainingCenter.getCenterCode() + " is already present");
			}

			trainingCenter.setCreatedOn(LocalDate.now()); // setting local date from system
			trainingCenterRepository.save(trainingCenter); // saving in database
			return ResponseEntity.ok().body(convertEntityToDto(trainingCenter));
		} catch (Exception e) {
			// Handle the exception here
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while adding the training center." + e.getMessage());
		}
	}

	// entity to dto conversion
	private TrainingCenterDTO convertEntityToDto(TrainingCenter trainingCenter) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		TrainingCenterDTO trainingCenterDTO = new TrainingCenterDTO();
		trainingCenterDTO = modelMapper.map(trainingCenter, TrainingCenterDTO.class);
		return trainingCenterDTO;
	}

}
