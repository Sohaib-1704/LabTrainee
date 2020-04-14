package com.cg.demo.service;

import java.util.List;

import com.cg.demo.entity.Trainee;

public interface TraineeServiceInterface {

	public Trainee save(Trainee trainee);

	public List<Trainee> reterive();

	public boolean existsById(int id);

	public void updateData(Trainee trainee);

	public Trainee findById(int id);

	public void deleteById(int id);

}
