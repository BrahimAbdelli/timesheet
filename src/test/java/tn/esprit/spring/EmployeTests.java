package tn.esprit.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTests {
	
	@Autowired
	EmployeServiceImpl EmployeServiceImpl;	
	
	
	@Test
	public void getEmployePrenomById() {
		
		assertNotNull(EmployeServiceImpl.getEmployePrenomById(3));

	}

	@Test
	public void getNombreEmployeJPQL() {

		assertEquals(9,(EmployeServiceImpl.getNombreEmployeJPQL()));

	}	
	
	@Test
	public void getSalaireByEmployeIdJPQLTrue() {

		assertTrue((EmployeServiceImpl.getSalaireByEmployeIdJPQL(3))<150000);

	}
	
	@Test
	public void getSalaireByEmployeIdJPQLFalse() {

		assertFalse((EmployeServiceImpl.getSalaireByEmployeIdJPQL(3))>150000);

	}	
		
}
