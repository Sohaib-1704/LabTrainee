package com.cg.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.entity.Trainee;
import com.cg.demo.repository.TraineeRepoInterface;

@Transactional
@Service
public class TraineeService implements TraineeServiceInterface {
	@Autowired
	private TraineeRepoInterface traineeRepo;

	@Override
	public Trainee save(Trainee trainee) {
		traineeRepo.create(trainee);
		return trainee;
	}

	@Override
	public List<Trainee> reterive() {
		return traineeRepo.reterive();
	}
	@Override
	public Trainee findById(int id) {
		return traineeRepo.findById(id);
	}
	@Override
	public boolean existsById(int id) {
		return traineeRepo.findID(id);
	}

	@Override
	public void deleteById(int id) {
		traineeRepo.delete(id);
	}

	@Override
	public void updateData(Trainee train) {
		traineeRepo.update(train);
		
	}
}
