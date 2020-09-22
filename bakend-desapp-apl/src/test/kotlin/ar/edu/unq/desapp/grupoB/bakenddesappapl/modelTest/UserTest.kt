package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.*
import javolution.testing.AssertionException
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.assertj.AssertableApplicationContext
import java.time.LocalDate


class UserTest {

    var user: User?              = null
    var userAdministrator: User? = null
    var bernal : Location?       = null
    var quilmes : Location?      = null
    var fecha : LocalDate?       = null
    var dateI: LocalDate?        = null
    var todayDate: LocalDate?    = null
    var project : Project?       = null
    var project2 : Project?      = null
    var project3: Project?       = null

    @BeforeEach
    fun setUp(){


        user              = User("Lara","laraA@gmail.com","lara", false,"ara")
        userAdministrator = User("tomas","tomasA@gmail.com","lara", true,"ara")
        bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        quilmes = Location("Quilmes", "Buenos Aires", 12000, false)

        fecha     = LocalDate.of(2020,5,12)
        dateI     = LocalDate.of(2020, 5, 1)
        todayDate = LocalDate.now()
        project   = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)
        project2  = Project("ProjectQuilmes",fecha!!, LocalDate.of(2020,7,8), quilmes!!)
        project3  = Project("Project2", dateI!!,todayDate!!,bernal!!)

    }

    @Test
    fun AUserIsCreatedAndYourNameIsVerified(){

        Assert.assertEquals(user!!.nameUser,"Lara")

    }

    @Test
    fun AUserIsCreatedAndYourEmailIsVerified(){

        Assert.assertEquals(user!!.email,"laraA@gmail.com")

    }

    @Test
    fun AUserIsCreatedAndYourPasswordIsVerified(){

        Assert.assertEquals(user!!.password,"lara")

    }

    @Test
    fun AUserIsCreatedAndYourNickNameIsVerified(){

        Assert.assertEquals(user!!.nickName,"ara")

    }

    @Test
    fun AUserIsCreatedAndVerifiedIfYouAreAnAdministrator(){

        Assert.assertEquals(user!!.isAdmin,false)

    }

    @Test
    fun AUserIsCreatedWithoutPointsAndVerified(){

        Assert.assertEquals(user!!.points,0)

    }

    @Test
    fun iCreateAUserAndVerifyThatTheListOfClosedProjectsIsEmptyBecauseIDidNotMakeADonation(){

        Assert.assertEquals(user!!.listOfClosedProjects.size,0)
    }

    @Test
    fun AuserCollaboratesOnAProjectWithMoreThan1000(){

        user!!.collaboratesOnAProject(project!!,1200, LocalDate.of(2020,5,12))

        Assert.assertEquals(user!!.points,1200)

    }

    @Test
    fun AuserCollaboratesOnAProjectWithMoreThan2000Inhabitant(){

        user!!.collaboratesOnAProject(project2!!,100, LocalDate.of(2020,5,12))

        Assert.assertEquals(user!!.points,200)
        Assert.assertEquals(project2!!.donorUsers.size,1)
    }

    @Test
    fun collaborateOnAProjectTwiceInTheSameMonth(){

        user!!.collaboratesOnAProject(project2!!,100, LocalDate.of(2020,5,12))
        user!!.collaboratesOnAProject(project2!!,300, LocalDate.of(2020,5,15))


        Assert.assertEquals(user!!.points,800)
    }
    @Test
    fun givenAProjectINotifyitsDonorUsersThatItEnded() {
        user!!.collaboratesOnAProject(project!!, 400, LocalDate.of(2015, 5, 3))
        project!!.notifyDonorsThatTheProjectHasEnded()

        Assert.assertEquals(user!!.listOfClosedProjects.size,1)

    }

   @Test
    fun IThrowAnExceptionWhenIWantToCheckIfAProjectIsFinishedAndIAmNotAnAdministrator(){

        user!!.collaboratesOnAProject(project!!,400, LocalDate.of(2015,5,3))

         assertThrows<Exception> { user!!.projectFinished(project!!)}
    }

    @Test
    fun aUserWhoIsAnAdministratorNotifiesThaTheProjectEnded(){
        userAdministrator!!.collaboratesOnAProject(project3!!,6000000, LocalDate.of(2015,5,3))
        userAdministrator!!.projectFinished(project3!!)

        Assert.assertEquals(userAdministrator!!.listOfClosedProjects.size,1)
    }

    @Test
    fun userHasTheTop10Available(){

        var aplication = Aplication()
        aplication.userRegister(user!!)
        aplication.addProjects(project!!)
        aplication.cambiarFecha(LocalDate.now())

        Assert.assertEquals("the top 10 are already available", user!!.cambio)
    }

}