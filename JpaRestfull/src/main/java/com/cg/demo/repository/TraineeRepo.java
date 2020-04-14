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
	@Override
	public Trainee findById(int id) {
		return entitymanager.find(Trainee.class, id);
	}
	public boolean findID(int id){
		if(entitymanager.contains(entitymanager.find(Trainee.class, id))){
			return true;
		}
		return false;
	}
	@Override
	public void delete(int id) {
		Trainee train=entitymanager.find(Trainee.class, id);
		System.out.println(train.getId() +" "+train.getName()+ " "+train.getDomain()+" "+train.getLocation()+" is removed");
		entitymanager.remove(train);
	}
	@Override
	public void update(Trainee train) {
		  Trainee traineeUpdate= entitymanager.find(Trainee.class, train.getId());		
	      traineeUpdate.setName(train.getName());
	      traineeUpdate.setDomain(train.getDomain());
	      traineeUpdate.setLocation(train.getLocation());
	      System.out.println("update ");
		
	}

}
