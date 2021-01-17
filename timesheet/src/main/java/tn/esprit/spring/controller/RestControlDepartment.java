package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlDepartment {

	@Autowired
	IDepartementService idepservice; 
	
	// http://localhost:8081/SpringMVC/servlet/ajouterDep
	@PostMapping("/ajouterDep")
	@ResponseBody
	public Departement ajouterEmploye(@RequestBody Departement d)
	{
		idepservice.addOrUpdateDep(d);
		return d;
	}

	 // URL : http://localhost:8081/SpringMVC/servlet/getAllDepts
	@GetMapping(value = "/getAllDepts")
    @ResponseBody
	public List<Departement> getAllDepartments() {
		
		return idepservice.getAllDepartements();
	}

	
	
}
