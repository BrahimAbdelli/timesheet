package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	 
	
	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("In  ajouterEntreprise : " + entreprise); 
		entrepriseRepoistory.save(entreprise);
		l.info(" Out ajouterEntreprise. ");
		return entreprise.getId();
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise e) {
		l.info("In  updateEntreprise : " + e); 
		return entrepriseRepoistory.save(e);		
	}
	public int ajouterDepartement(Departement dep) {
		l.info("In  ajouterDepartement: " + dep); 
		deptRepoistory.save(dep);
		l.info("Out  ajouterDepartement: " + dep); 
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("in  getAllDepartementsNamesByEntreprise = " + entrepriseId);
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		l.info("depNames returned : " + depNames);
		
		return depNames;
	}


	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try {
			l.info(" search for entreprise");
			Entreprise e = entrepriseRepoistory.findById(entrepriseId).get();
			l.info(" found entreprise");
			l.info(" deleting  entreprise");
		entrepriseRepoistory.delete(e);
		l.info(" operation finish  entreprise");
		} catch (Exception ex) {
			l.error("entreprise could not be found !!!!");	
		}
	}
	
	@Override
	public List<Entreprise> getAllEntreprises() {
		l.info("In  retrieveAllEntreprises : "); 
		List<Entreprise> Entreprises = (List<Entreprise>) entrepriseRepoistory.findAll();  
		for (Entreprise e : Entreprises) {
			l.debug("entreprise +++ : " + e);
		}
		l.info("Out of retrieveAllEntreprises."); 
		return Entreprises;
	}

	@Override
	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("in  retrieveEntreprise id = " + entrepriseId);
			if( entrepriseRepoistory.existsById(entrepriseId)==false)
			{
				return null;
			}
			l.info("entreprise returned : " + entrepriseRepoistory.findById(entrepriseId).get());
			return entrepriseRepoistory.findById(entrepriseId).get();
	}
	///hello test 

}
