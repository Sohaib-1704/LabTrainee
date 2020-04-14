package com.cg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PutMapping("/updatetrainee/{traineeId}")
	public ResponseEntity<Trainee> updatetrainee(@PathVariable("traineeId") int id,@RequestBody Trainee trainee){
	    if (traineeService.existsById(id)==false){
	    	 return new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
		}
	    traineeService.updateData(trainee);
	    return new ResponseEntity<Trainee>(trainee,HttpStatus.OK);	
	}
	
	@GetMapping("/gettrainee/{traineeId}")
    public ResponseEntity<Trainee> gettrainee (@PathVariable("traineeId") int id) {
		if(traineeService.existsById(id)) {
			Trainee train = traineeService.findById(id);
			return new ResponseEntity<Trainee>(train,HttpStatus.OK);
		}
		return new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deletetrainee/{traineeId}")
    public ResponseEntity<Trainee> deletetraineeId (@PathVariable("traineeId") int id) {
		if(traineeService.existsById(id)){
			traineeService.deleteById(id);
		return new ResponseEntity<Trainee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
	}
}
