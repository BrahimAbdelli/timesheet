package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import tn.esprit.spring.entities.Entreprise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;

import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTests {
	@Autowired 
	IEntrepriseService us; 
	
	@Test
	public void testAjouterEntreprise() throws ParseException {
		Entreprise e = new Entreprise("hello", "world ");
		int entrepriseAdded= us.ajouterEntreprise(e); 
		
		            //Expected  //Actual
		assertEquals(e.getId(), entrepriseAdded);
	}
	
	@Test
	public void testdeleteEntreprise() throws ParseException {

		us.deleteEntrepriseById(10); 
		//The actual value is null test will pass otherwise test fails
		
	    assertNull(us.getEntrepriseById(10));			
	}
	
	@Test
	public void testupdateEntreprise() throws ParseException {
		
		Entreprise e = new Entreprise(9,"update", "world ");

		Entreprise entrepriseAdded= us.updateEntreprise(e); 
		assertEquals(e.getRaisonSocial(), entrepriseAdded.getRaisonSocial());
		assertEquals(e.getName(), entrepriseAdded.getName());
	}
	
	@Test
	public void testGetAllEntreprise() {
		
		List<Entreprise> Entreprises = us.getAllEntreprises(); 
		assertEquals(21, Entreprises.size());
	}
	
	
	@Test
	public void testGetEntrepriseById() {
		Entreprise entrepriseRetrieved = us.getEntrepriseById(18); 
		assertEquals(18, entrepriseRetrieved.getId());
	}
	

}
