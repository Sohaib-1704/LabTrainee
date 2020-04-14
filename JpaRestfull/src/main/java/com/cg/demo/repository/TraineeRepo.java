package com.cg.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.demo.entity.Trainee;

@Transactional
@Repository
public class TraineeRepo implements TraineeRepoInterface{
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public void create(Trainee trainee) {
		entitymanager.persist(trainee);		
	}
	@Override
	public List<Trainee> reterive() {
		String Qstr = "SELECT trainee FROM Trainee trainee";
		TypedQuery<Trainee> query = entitymanager.createQuery(Qstr, Trainee.class);
		return query.getResultList();
	}
}
