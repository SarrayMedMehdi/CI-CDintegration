package tn.esprit.spring;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EmployeServiceTests {
	
	@Autowired
	IEmployeService employeService;
	
	Logger logger = LogManager.getLogger(EmployeServiceTests.class);
	
	
	@BeforeEach
	public void CreateEmployeTest(){
	logger.info("Creating the Employe Entity");
	Employe emp = new Employe();
	    emp.setActif(true);
		emp.setContrat(null);
		emp.setDepartements(null);
		emp.setNom("Junit");
		emp.setPrenom("Junit");
		emp.setPassword("Junit");
		emp.setRole(Role.ADMINISTRATEUR);
		emp.setEmail("Junit");
	int	result = employeService.addOrUpdateEmploye(emp);
	 logger.info("Add/UpdateEMP executed");
	 Assertions.assertTrue(result > 0);
	}
	
	@Test
	public void getAllEmployeTest(){
		logger.info("Launching getAllEmployeTest");
		List<Employe> emp ;
		emp = employeService.getAllEmployes();
		Assertions.assertNotNull(emp);
	}
	
	

}
