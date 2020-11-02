package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ContratServiceImplTest {

	@Autowired 
	IContratService cs;
	
	
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-10-23");
		Contrat c = new Contrat(11,d,"CDI",5500 ); 
		Contrat contratUpdated  = cs.updateContrat(c); 
		assertEquals(c.getTypeContrat(), contratUpdated .getTypeContrat());
	}
	
	
	
	@Test 
	public void testDeleteContrat(){
		Contrat c = cs.retrieveContratById(12);
		cs.deleteContrat(12);
	}
	
	/*@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.retrieveAllContrats(); 
		assertEquals(5, listContrats.size());
	}*/
	
	@Test
	public void testRetrieveContract() {
		Contrat contratRetrieved = cs.retrieveContratById(11); 
		assertEquals(11, contratRetrieved.getReference());
	}
	
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-03-23");
		Contrat u = new Contrat(d,"CDD",2500 ); 
		Contrat contratAdded = cs.addContrat(u);
		assertEquals(u.getTypeContrat(), contratAdded.getTypeContrat());
	}
	
}