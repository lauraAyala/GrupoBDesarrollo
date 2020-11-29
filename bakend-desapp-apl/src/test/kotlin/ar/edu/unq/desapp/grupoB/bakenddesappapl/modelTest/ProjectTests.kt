package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProjectTests {


    @Test
    fun test01aNewProjectIsCreatedAndIVerifyItsName() {

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI= LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)

        Assert.assertEquals(project!!.nameProject, "ProjectInitial")
    }

    @Test
    fun test02OfTheNewProjectIVerifyItsLocation() {

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI= LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)

        Assert.assertEquals(project!!.locationP, quilmes)
    }

    @Test
    fun test03OfTheNewProjectIVerifyItsStartDateAndEndDate() {

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI= LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)

        Assert.assertEquals(project!!.dateInit, dateI)
    }

    @Test
    fun testICreateANewProjectAndVerifyThatTheListOfDonorUsersIsEmpty(){
        var wilde = Location("Wilde", "Buenos Aires", 10000, false)
        var dateI= LocalDate.of(2020, 5, 1)
        var projectNew = Project("Project new", dateI!!, LocalDate.of(2020,7,8),wilde!!)


        Assert.assertEquals(projectNew!!.donorUsers.size,0)
    }

    @Test
    fun test04GivenAProjectIVerifyHowMuchICollectFromDonations(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var user2 = User("Isaias","isa@gmail.com","isaias", false,"ara")

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var donorIsaias = Donor(user2, 500, LocalDate.of(2020,4,11))
        var donorPepe   = Donor(user, 1000, LocalDate.of(2020,4,11))
        quilmes!!.donorRegister(donorIsaias!!)
        quilmes!!.donorRegister(donorPepe!!)
        var dateI       = LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)


        Assert.assertEquals(1500,project!!.amountCollected())
    }

    @Test
    fun test05VerifyIfItIsTheEndDateOfTheProject(){

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2021,7,8),quilmes!!)

        Assert.assertEquals(false,project!!.itsProjectEndDate())
    }

    @Test
    fun test06ICreateAProjectWithAnEndDateToday(){

        var bernal = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var todayDate   = LocalDate.now()
        var project2    = Project("Project2", dateI!!,todayDate!!,bernal!!)


        Assert.assertEquals(true, project2!!.itsProjectEndDate())


    }
    @Test
    fun test07GivenAProjectIVerifyIfTheMinimumRequiredWasCollected() {

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)


        Assert.assertEquals(project!!.theMinimunFinancingOfTheWorkWasCollected(), false)
    }

    @Test
    fun test08GivenAProjectThatReceivedDonationsIVerifyThatTheMinimumRequiredHasBeenCollected(){

        var user = User("Jose","jose@gmail.com","jose", false,"jose")

        var bernal      = Location("Quilmes", "Buenos Aires", 10000, false)
        var donorJose   = Donor(user, 6000000, LocalDate.of(2020,4,11))
        bernal!!.donorRegister(donorJose!!)
        var todayDate   = LocalDate.now()
        var dateI       = LocalDate.of(2020, 5, 1)
        var project2    = Project("Project2", dateI!!,todayDate!!,bernal!!)



        Assert.assertEquals(project2!!.moneyneeded(),10000000)
        Assert.assertEquals(project2!!.amountCollected(),6000000)
        Assert.assertEquals(project2!!.calculateMinimumClosingPorcentage(),5000000)
        Assert.assertEquals(project2!!.theMinimunFinancingOfTheWorkWasCollected(),true)
    }

    @Test
    fun lastDonationFromProject(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var user2 = User("Isaias","isa@gmail.com","isaias", false,"ara")

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var donorPepe   = Donor(user, 1000, LocalDate.of(2020,4,11))
        var donorIsaias = Donor(user2, 500, LocalDate.of(2020,4,11))
        quilmes!!.donorRegister(donorPepe!!)
        quilmes!!.donorRegister(donorIsaias!!)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)


        Assert.assertEquals(donorIsaias,project!!.lastDonation())
    }
    @Test
    fun numbreInabitantsOfAnProject(){

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)

        Assert.assertEquals(10000,project!!.numberOfInhabitants)

    }

    @Test
    fun collectionOfAnProjectc(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var user2 = User("Isaias","isa@gmail.com","isaias", false,"ara")

        var quilmes = Location("Quilmes", "Buenos Aires", 10000, false)
        var dateI       = LocalDate.of(2020, 5, 1)
        var donorIsaias = Donor(user2, 500, LocalDate.of(2020,4,11))
        var donorPepe   = Donor(user, 1000, LocalDate.of(2020,4,11))
        quilmes!!.donorRegister(donorPepe!!)
        quilmes!!.donorRegister(donorIsaias!!)
        var project = Project("ProjectInitial", dateI!!, LocalDate.of(2020,7,8),quilmes!!)


        project!!.amountCollected()

        Assert.assertEquals(1500,project!!.collection)

    }


}
