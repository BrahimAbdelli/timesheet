package tn.esprit.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTests {
	
	@Autowired
	EmployeServiceImpl EmployeServiceImpl;
	
	
	@Test
	public void testAuthenticate() {
//		Contrat c = new Contrat();

		// {"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}


		assertNotNull(EmployeServiceImpl.authenticate("ccc", "ccc"));

	}
}
