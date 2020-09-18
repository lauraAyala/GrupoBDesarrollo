package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Aplication
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AplicationTest {

    var project: Project?  = null
    var project2: Project?  = null
    var project3: Project?  = null
    var quilmes: Location?  = null
    var bernal: Location?  = null
    var user: User?  = null
    var user2: User?  = null
    var user3: User?  = null


    var aplication: Aplication?  = null

    @BeforeEach
    fun setUp(){

        quilmes = Location("Quilmes","Buenos Aires",12000,false)
        bernal = Location("Bernal","Buenos Aires",13000,false)

        project = Project("Caritas", 13, LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes!!)
        project2 = Project("pr", 13, LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal!!)
        project3 = Project("Crecer", 13, LocalDate.of(2020,4,9), LocalDate.of(2020,9,15),bernal!!)

        user = User("Maria","maria@gmail.com","maria",false,"m")
        user2 = User("Mario","mario@gmail.com","mario",false,"ma")
        user3 = User("Iara","maria@gmail.com","iara",false,"ia")



        aplication = Aplication()

    }

    @Test
    fun aNewlyCreatedApplicationHasNotUsers() {

        Assert.assertEquals(aplication!!.listUsers.size, 0)
    }

    @Test
    fun aAplicationRegisterUser() {

        aplication!!.userRegister(user!!)

        Assert.assertTrue(aplication!!.listUsers.contains(user!!))
    }

    @Test
    fun aNewlyCreatedApplicationHasNotProjects() {

        Assert.assertEquals(aplication!!.listProjects.size, 0)
    }

    @Test
    fun aAplicationRegisterAnProject() {

        aplication!!.addProjects(project!!)

        Assert.assertTrue(aplication!!.listProjects.contains(project!!))
    }

    @Test
    fun anApplicationForItsOpenProjects() {

        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)

        Assert.assertEquals(aplication!!.listOfOpenProjects().size,2)
        Assert.assertTrue(aplication!!.listOfOpenProjects().contains(project!!))
        Assert.assertTrue(aplication!!.listOfOpenProjects().contains(project2!!))

    }

    @Test
    fun anApplicationForItsCloseProjects() {

        aplication!!.addProjects(project!!)
        aplication!!.addProjects(project2!!)
        aplication!!.addProjects(project3!!)

        Assert.assertEquals(aplication!!.listOfProjectsNearingCompletion().size,1)
        Assert.assertTrue(aplication!!.listOfProjectsNearingCompletion().contains(project3!!))

    }

    @Test
    fun stateOfConectiveOfAnProject(){

        Assert.assertEquals(aplication!!.moneyToProvideInternet(project!!), 12000000)
    }

    @Test
    fun Top10Locations(){

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
}