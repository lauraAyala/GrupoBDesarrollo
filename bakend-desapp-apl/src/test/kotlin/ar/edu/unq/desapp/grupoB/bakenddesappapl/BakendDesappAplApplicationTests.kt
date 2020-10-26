package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.controller.ProjectController
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class BakendDesappAplApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun testHomeController() {
		val projectController = ProjectController(ProjectService())
		var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
		var dateI= LocalDate.of(2020, 5, 1)
		var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)

		val res = projectController.createdProject(project)
		Assert.assertEquals(res.body!!.nameProject, "ProjectInitial")
	}
}
