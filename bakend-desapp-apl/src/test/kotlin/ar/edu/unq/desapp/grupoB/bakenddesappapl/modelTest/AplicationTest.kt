package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.*
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AplicationTest {
    
    @Test
    fun aNewlyCreatedApplicationHasNotUsers() {

         var aplication    = Aplication()


        Assert.assertEquals(aplication!!.listUsers.size, 0)
    }

    @Test
    fun aAplicationRegisterUser() {

        var aplication    = Aplication()
        var user  = User("Maria","maria@gmail.com","maria",false,"m")

        aplication!!.userRegister(user!!)

        Assert.assertTrue(aplication!!.listUsers.contains(user!!))
    }

    @Test
    fun aNewlyCreatedApplicationHasNotProjects() {

        var aplication    = Aplication()

        Assert.assertEquals(aplication!!.listProjects.size, 0)
    }

    @Test
    fun aAplicationRegisterAnProject() {

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)


        aplication!!.addProjects(project!!)

        Assert.assertTrue(aplication!!.listProjects.contains(project!!))
    }

    @Test
    fun anApplicationForItsOpenProjects() {

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)
        var bernal   = Location("Bernal","Buenos Aires",13000,false)
        var project2 = Project("pr", LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)

        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)

        Assert.assertEquals(aplication!!.listOfOpenProjects().size,2)
        Assert.assertTrue(aplication!!.listOfOpenProjects().contains(project!!))
        Assert.assertTrue(aplication!!.listOfOpenProjects().contains(project2!!))

    }

    @Test
    fun anApplicationForItsCloseProjects() {

        //hay que revisar

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)
        var bernal   = Location("Bernal","Buenos Aires",13000,false)
        var project2 = Project("pr", LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)
        var project3 = Project("Crecer", LocalDate.of(2020,4,9), LocalDate.of(2020,9,15),bernal!!)


        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)
        aplication!!.addProjects(project3!!)

        Assert.assertEquals(aplication!!.listOfProjectsNearingCompletion().size,0)
      //  Assert.assertTrue(aplication!!.listOfProjectsNearingCompletion().contains(project3!!))

    }

    @Test
    fun moneyToProvideInternetOfAnProject(){

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)


        Assert.assertEquals(aplication!!.moneyToProvideInternet(project!!), 12000000)
    }

    @Test
    fun moneyToProvideInternetOfAnProjectWhithFactorIn200(){

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)

        project!!.factor = 200
        aplication!!.addProjects(project!!)

        Assert.assertEquals(aplication!!.moneyToProvideInternet(project!!), 2400000)
    }


    @Test
    fun Top10Locations(){

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)
        var bernal   = Location("Bernal","Buenos Aires",13000,false)
        var project2 = Project("pr", LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)
        var project3 = Project("Crecer", LocalDate.of(2020,4,9), LocalDate.of(2020,9,15),bernal!!)
        var user  = User("Maria","maria@gmail.com","maria",false,"m")
        var user2 = User("Mario","mario@gmail.com","mario",false,"ma")
        var user3 = User("Iara","maria@gmail.com","iara",false,"ia")


        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)
        aplication!!.addProjects(project3!!)

        aplication!!.userRegister(user!!)
        aplication!!.userRegister(user2!!)
        aplication!!.userRegister(user3!!)



        user!!.collaboratesOnAProject(project!!,400, LocalDate.of(2020,2,12))
        user2!!.collaboratesOnAProject(project2!!,500, LocalDate.of(2020,3,12))
        user3!!.collaboratesOnAProject(project!!,300, LocalDate.of(2020,4,12))

        Assert.assertEquals(aplication!!.top10Locations().size, 2 )
    }
    @Test
    fun fromTheApplicationIVerifyTheAmountCollectedFromTheNewProjectThatDidNotReceiveDonations(){

        var aplicationNew = Aplication()
        var bernal   = Location("Bernal","Buenos Aires",13000,false)
        var project2 = Project("pr", LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)


        Assert.assertEquals(aplicationNew!!.totalCollected(project2!!),0)
    }

    @Test
    fun fromTheApplicationIVerifyTheAmountCollectedFromTheNewProjectThatReceiveTwoDonations(){

        var aplicationNew = Aplication()
        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var user2 = User("Isaias","isa@gmail.com","isaias", false,"ara")

        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var donorPepe   = Donor(user, 1000, LocalDate.of(2020,4,11))
        var donorIsaias = Donor(user2, 500, LocalDate.of(2020,4,11))
        quilmes!!.donorRegister(donorPepe!!)
        quilmes!!.donorRegister(donorIsaias!!)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)


        Assert.assertEquals(aplicationNew!!.totalCollected(project!!),1500)
    }

    @Test
    fun Top10Donations() {

        var aplication    = Aplication()
        var quilmes     = Location("Quilmes","Buenos Aires",12000,false)
        var project  = Project("Caritas", LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)
        var bernal   = Location("Bernal","Buenos Aires",13000,false)
        var project2 = Project("pr", LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)
        var project3 = Project("Crecer", LocalDate.of(2020,4,9), LocalDate.of(2020,9,15),bernal!!)
        var user  = User("Maria","maria@gmail.com","maria",false,"m")
        var user2 = User("Mario","mario@gmail.com","mario",false,"ma")
        var user3 = User("Iara","maria@gmail.com","iara",false,"ia")


        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)
        aplication!!.addProjects(project3!!)

        aplication!!.userRegister(user!!)
        aplication!!.userRegister(user2!!)
        aplication!!.userRegister(user3!!)



        user!!.collaboratesOnAProject(project!!, 400, LocalDate.of(2020, 2, 12))
        user2!!.collaboratesOnAProject(project2!!, 500, LocalDate.of(2020, 3, 12))
        user3!!.collaboratesOnAProject(project!!, 300, LocalDate.of(2020, 4, 12))

        Assert.assertEquals(3, aplication!!.top10Donations().size)

    }
}