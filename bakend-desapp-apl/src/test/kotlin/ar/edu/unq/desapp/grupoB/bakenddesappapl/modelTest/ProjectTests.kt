package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProjectTests {

    var project: Project?     = null
    var project2: Project?    = null
    var quilmes: Location?    = null
    var bernal: Location?     = null
    var dateI: LocalDate?     = null
    var todayDate: LocalDate? = null
    var donorPepe: Donor?     = null
    var donorIsaias: Donor?   = null
    var donorJose: Donor?     = null

    @BeforeEach
    fun setUp() {
        dateI       = LocalDate.of(2020, 5, 1)
        todayDate   = LocalDate.now()
        donorPepe   = Donor("pepe", 1000, LocalDate.of(2020,4,11))
        donorIsaias = Donor("Isaias", 500, LocalDate.of(2020,4,11))
        donorJose   = Donor("Jose", 6000000, LocalDate.of(2020,4,11))
        quilmes     = Location("Quilmes", "Buenos Aires", 10000, false)
        bernal      = Location("Quilmes", "Buenos Aires", 10000, false)
        quilmes!!.donorRegister(donorPepe!!)
        quilmes!!.donorRegister(donorIsaias!!)
        bernal!!.donorRegister(donorJose!!)
        project     = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)
        project2    = Project("Project2", dateI!!,todayDate!!,bernal!!)
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

    @Test
    fun test05VerifyIfItIsTheEndDateOfTheProject(){
        Assert.assertEquals(project!!.itsProjectEndDate(),false)
    }

    @Test
    fun test06ICreateAProjectWithAnEndDateToday(){
        Assert.assertEquals(project2!!.itsProjectEndDate(),true)
    }
    @Test
    fun test07GivenAProjectIVerifyIfTheMinimumRequiredWasCollected() {
        Assert.assertEquals(project!!.theMinimunFinancingOfTheWorkWasCollected(), false)
    }

    @Test
    fun test08GivenAProjectThatReceivedDonationsIVerifyThatTheMinimumRequiredHasBeenCollected(){
        Assert.assertEquals(project2!!.moneyneeded(),10000000)
        Assert.assertEquals(project2!!.amountCollected(),6000000)
        Assert.assertEquals(project2!!.calculateMinimumClosingPorcentage(),5000000)
        Assert.assertEquals(project2!!.theMinimunFinancingOfTheWorkWasCollected(),true)
    }

    @Test
    fun lastDonationFromProject(){

        Assert.assertEquals(donorIsaias,project!!.lastDonation())
    }
    @Test
    fun numbreInabitantsOfAnProject(){

        Assert.assertEquals(10000,project!!.numberOfInhabitants)

    }

}
