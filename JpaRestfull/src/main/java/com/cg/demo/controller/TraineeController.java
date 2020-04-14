package com.cg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entity.Trainee;
import com.cg.demo.service.TraineeServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TraineeController {
	@Autowired
	private TraineeServiceInterface traineeService;

	@PostMapping("/trainee")
	public ResponseEntity<Trainee> saveTrainee(@RequestBody Trainee trainee) {

		Trainee train = traineeService.save(trainee);

		return new ResponseEntity<Trainee>(train, HttpStatus.OK);
	}

	@GetMapping("/getTrainees")
	public ResponseEntity<List<Trainee>> getAllTrainees() {
		List<Trainee> list = traineeService.reterive();
		return new ResponseEntity<List<Trainee>>(list, HttpStatus.OK);
	}
}
