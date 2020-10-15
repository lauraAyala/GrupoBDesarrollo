package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.LocationService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

class ProjectServiceTest {

    /*var daoLocation = HibernateLocationDao()
    var serviceLocation = LocationServiceImpl(daoLocation,DataServiceImpl())
    var dao = HibernateProjectDAO()
    var service = ProjectServiceImpl(dao,DataServiceImpl())*/

    var service = ProjectService()
    var serviceLocation = LocationService()

    @Test
    fun createdAnProject(){

        var dateE = LocalDate.of(2020,6,14)
        var dateF = LocalDate.of(2020,7,14)
        var location = Location("F Varela","Buenos Aires", 2000, false)

        location = serviceLocation.createdLocation(location)
        var project = Project("caritas", dateE,dateF,location)
        service.createdProject(project)

        Assert.assertEquals("caritas", service.recoverProject(project.id!!).nameProject)

    }

    @Test
    fun allProjects(){

        var dateE = LocalDate.of(2020,6,14)
        var dateF = LocalDate.of(2020,7,14)
        var location = Location("Bosques","Buenos Aires", 2000, false)
        var wilde = Location("Wilde","Buenos Aires", 3000, false)

        location = serviceLocation.createdLocation(location)
        wilde = serviceLocation.createdLocation(wilde)
        var project = Project("lujan", dateE,dateF,location)
        var project2 = Project("crecer", LocalDate.of(2020,8,16), LocalDate.of(2020,9,8), wilde)
        service.createdProject(project)
        service.createdProject(project2)

        Assert.assertEquals(2,service.allProjects().size)
        Assert.assertTrue(service.allProjects().any { it.nameProject == "lujan" })

    }
}