package com.cg.demo.repository;

import java.util.List;

import com.cg.demo.entity.Trainee;

public interface TraineeRepoInterface {

	public void create(Trainee trainee);

	public List<Trainee> reterive();

	public Trainee findById(int id);

	public boolean findID(int id);

	public void delete(int id);

	public void update(Trainee train);

}
