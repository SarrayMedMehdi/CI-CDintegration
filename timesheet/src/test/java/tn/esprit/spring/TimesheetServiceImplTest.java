package tn.esprit.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
public class TimesheetServiceImplTest {

	@Autowired
	ITimesheetService timesheet;
	@Autowired
	IDepartementService departementService;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	
	Logger logger = LogManager.getLogger(TimesheetServiceImplTest.class);
	
	@BeforeEach
	private void deleteRecords(){
		logger.info("Clean records");
		missionRepository.deleteAll();
		deptRepoistory.deleteAll();
	}
	
	@Test
	void testAjouterMission() {
		logger.info("Creating the Mission instance");
		Mission mission = new Mission();
		mission.setDescription("desc");
		mission.setName("name");
		int	result = timesheet.ajouterMission(mission);
		logger.info("Add mission executed");
		Assertions.assertTrue(result > 0);
	}
	
	@Test
	void testAffecterMissionADepartement() {
		logger.info("Creating the Mission instance");
		Mission mission = new Mission();
		int	idMissionInserted = timesheet.ajouterMission(mission);
		logger.info("Creating the Department instance");
		Departement departement = new Departement();
		Departement	departementInserted = departementService.addOrUpdateDep(departement);
		logger.info("Affect Mission to Departement");
		timesheet.affecterMissionADepartement(idMissionInserted, departementInserted.getId());
		Mission missionAfect = missionRepository.findById(idMissionInserted).get();
		logger.info("checking the mission");
		Assertions.assertNotNull(missionAfect.getDepartement());
		logger.info("Affect Mission to Departement executed");
	}
	
}

