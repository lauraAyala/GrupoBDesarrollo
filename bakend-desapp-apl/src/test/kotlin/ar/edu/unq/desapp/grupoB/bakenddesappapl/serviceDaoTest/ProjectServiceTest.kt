package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateLocationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateProjectDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DataServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.LocationServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.ProjectServiceImpl
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProjectServiceTest {

    var daoLocation = HibernateLocationDao()
    var serviceLocation = LocationServiceImpl(daoLocation,DataServiceImpl())
    var dao = HibernateProjectDAO()
    var service = ProjectServiceImpl(dao,DataServiceImpl())

    @Test
    fun createdAnProject(){

        var dateE = LocalDate.of(2020,6,14)
        var dateF = LocalDate.of(2020,7,14)
        var location = Location("F Varela","Buenos Aires", 2000, false)

        location = serviceLocation.createdLocation(location)
       // location = serviceLocation.recoverLocation(1)
        var project = Project("caritas", dateE,dateF,location)
        service.createdProject(project)

        Assert.assertEquals("caritas", service.recoverProject(location.id!!).nameProject)

    }
}