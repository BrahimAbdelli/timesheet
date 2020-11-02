package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetTests {
	@Autowired
	TimesheetServiceImpl TimesheetServiceImpl;
	@Autowired
	TimesheetRepository TR;
	@Autowired
	DepartementRepository DR;
	@Autowired
	MissionRepository MR;
	
	@Test
	public void testajouterMission()
	{
		Departement d= DR.findById(1).get();
		List<Timesheet> t=(List<Timesheet>) TR.findAll();
		Mission m=new Mission(2,"bla","bla",d,t);
		int timesheet= TimesheetServiceImpl.ajouterMission(m);
		assertEquals(2, timesheet);

		 	
	}
	@Test
	public void testaffecterMissionADepartement(){
		TimesheetServiceImpl.affecterMissionADepartement(1,2);
		Departement d= DR.findById(2).get();
		Mission m=new Mission(1,d);
		assertEquals(2,m.getDepartement().getId());
		
	}
	@Test
	public void testfindAllMissionByEmployeJPQL(){
		List<Mission> m = TimesheetServiceImpl.findAllMissionByEmployeJPQL(2);

			assertTrue(m.size()<3);

	}

	@Test
	public void testgetAllEmployeByMission(){
		List<Employe> e =TimesheetServiceImpl.getAllEmployeByMission(3);
		assertTrue(e.size()<=3);
	}
}
