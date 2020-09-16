package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProjectTests {

    var project: Project?  = null
    var quilmes: Location? = null
    var dateI: LocalDate?  = null
    var donorPepe: Donor?  = null
    var donorIsaias: Donor?  = null

    @BeforeEach
    fun setUp() {
        dateI     = LocalDate.of(2020, 5, 1)
        donorPepe = Donor("pepe", 1000, LocalDate.of(2020,4,11))
        donorIsaias = Donor("Isaias", 500, LocalDate.of(2020,4,11))
        quilmes   = Location("Quilmes", "Buenos Aires", 10000, false)
        quilmes!!.donorRegister(donorPepe!!)
        quilmes!!.donorRegister(donorIsaias!!)
        project   = Project("ProjectInitial", 10, dateI!!, LocalDate.of(2020,7,8),quilmes!!)
    }

    @Test
    fun test01aNewProjectIsCreatedAndIVerifyItsName() {

        Assert.assertEquals(project!!.nameProject, "ProjectInitial")
    }

    @Test
    fun test02OfTheNewProjectIVerifyItsLocation() {
        Assert.assertEquals(project!!.location, quilmes)
    }

    @Test
    fun test03OfTheNewProjectIVerifyItsStartDateAndEndDate() {
        Assert.assertEquals(project!!.dateInit, dateI)
    }

    @Test
    fun test04GivenAProjectIVerifyHowMuchICollectFromDonations(){
        Assert.assertEquals(project!!.amountCollected(),1500)
    }
}
