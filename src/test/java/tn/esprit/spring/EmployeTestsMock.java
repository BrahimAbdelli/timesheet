package tn.esprit.spring;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTestsMock {

	@MockBean
	EmployeRepository EmployeRepository;	
	
	@MockBean
	EmployeServiceImpl EmployeServiceImpl;
	
	
	@Test
	public void deleteContratById() {
		EmployeServiceImpl.deleteContratById(1);
		verify(EmployeServiceImpl,times(1)).deleteContratById(1);

	}
	
	@Test
	public void ajouterEmploye() {

		Employe employe = new Employe( "nom","prenom","email@email.com", true, Role.ADMINISTRATEUR);
		EmployeServiceImpl.addOrUpdateEmploye(employe);
		assertNotNull(EmployeServiceImpl.addOrUpdateEmploye(employe));

	}	
}
