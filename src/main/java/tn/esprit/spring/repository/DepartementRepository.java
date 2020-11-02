package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Integer>{

	public Mission findByMissions(int missionid);
}
