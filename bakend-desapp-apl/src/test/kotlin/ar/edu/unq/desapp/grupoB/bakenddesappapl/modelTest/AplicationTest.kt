package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Aplication
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AplicationTest {

   /* lateinit var project: Project
    lateinit var quilmes: Location
    lateinit var user: User*/
    var aplication = Aplication()
    var quilmes = Location("Quilmes","Buenos Aires",12000,false)
    var bernal = Location("Bernal","Buenos Aires",13000,false)
    var project = Project("Caritas", 13, LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes)
    var project2 = Project("pr", 13, LocalDate.of(2020,4,9), LocalDate.of(2020,5,9),bernal)
    var project3 = Project("Crecer", 13, LocalDate.of(2020,4,9), LocalDate.of(2020,9,15),bernal)


    var user = User("Maria","maria@gmail.com","maria",false,"m")

   /* @Before
    fun setUp(){

        quilmes = Location("Quilmes","Buenos Aires",12000,false)
        project = Project("Caritas", 13, LocalDate.of(2020,5,8), LocalDate.of(2020,7,8),quilmes)

        user = User("Maria","maria@gmail.com","maria",false,"m")


    }*/

    @Test
    fun aNewlyCreatedApplicationHasNotUsers() {

        Assert.assertEquals(aplication.listUsers.size, 0)
    }

    @Test
    fun aAplicationRegisterUser() {

        aplication.userRegister(user)

        Assert.assertTrue(aplication.listUsers.contains(user))
    }

    @Test
    fun aNewlyCreatedApplicationHasNotProjects() {

        Assert.assertEquals(aplication.listProjects.size, 0)
    }

    @Test
    fun aAplicationRegisterAnProject() {

        aplication.addProjects(project)

        Assert.assertTrue(aplication.listProjects.contains(project))
    }

    @Test
    fun anApplicationForItsOpenProjects() {

        aplication.addProjects(project)
        aplication.addProjects(project2)

        Assert.assertEquals(aplication.listOfOpenProjects().size,2)
        Assert.assertTrue(aplication.listOfOpenProjects().contains(project))
        Assert.assertTrue(aplication.listOfOpenProjects().contains(project2))

    }

    @Test
    fun anApplicationForItsCloseProjects() {

        aplication.addProjects(project)
        aplication.addProjects(project2)
        aplication.addProjects(project3)

        Assert.assertEquals(aplication.listOfProjectsNearingCompletion().size,1)
        Assert.assertTrue(aplication.listOfProjectsNearingCompletion().contains(project3))

    }

    @Test
    fun stateOfConectiveOfAnProject(){

        Assert.assertEquals(aplication.moneyToProvideInternet(project), 12000000)
    }



}