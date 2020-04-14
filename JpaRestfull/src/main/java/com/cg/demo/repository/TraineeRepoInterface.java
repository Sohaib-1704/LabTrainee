package com.cg.demo.repository;

import java.util.List;

import com.cg.demo.entity.Trainee;

public interface TraineeRepoInterface {

	public void create(Trainee trainee);

	public List<Trainee> reterive();

}
