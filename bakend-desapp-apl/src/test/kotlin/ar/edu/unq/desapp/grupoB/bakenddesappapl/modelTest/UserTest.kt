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

    @Test
    fun AUserIsCreatedAndYourNameIsVerified(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.nameUser,"Lara")

    }

    @Test
    fun AUserIsCreatedAndYourEmailIsVerified(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.email,"laraA@gmail.com")

    }

    @Test
    fun AUserIsCreatedAndYourPasswordIsVerified(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.password,"lara")

    }

    @Test
    fun AUserIsCreatedAndYourNickNameIsVerified(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.nickName,"ara")

    }

    @Test
    fun AUserIsCreatedAndVerifiedIfYouAreAnAdministrator(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.isAdmin,false)

    }

    @Test
    fun AUserIsCreatedWithoutPointsAndVerified(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.points,0)

    }

    @Test
    fun iCreateAUserAndVerifyThatTheListOfClosedProjectsIsEmptyBecauseIDidNotMakeADonation(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")

        Assert.assertEquals(user!!.listOfClosedProjects.size,0)
    }

    @Test
    fun AuserCollaboratesOnAProjectWithMoreThan1000(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        var fecha = LocalDate.of(2020,5,12)
        var project   = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)


        user!!.collaboratesOnAProject(project!!,1200, LocalDate.of(2020,5,12))

        Assert.assertEquals(user!!.points,1200)

    }

    @Test
    fun AuserCollaboratesOnAProjectWithMoreThan2000Inhabitant(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var fecha = LocalDate.of(2020,5,12)
        var quilmes = Location("Quilmes", "Buenos Aires", 12000, false)
        var project2  = Project("ProjectQuilmes",fecha!!, LocalDate.of(2020,7,8), quilmes!!)


        user!!.collaboratesOnAProject(project2!!,100, LocalDate.of(2020,5,12))

        Assert.assertEquals(user!!.points,200)
        Assert.assertEquals(project2!!.donorUsers.size,1)
    }

    @Test
    fun collaborateOnAProjectTwiceInTheSameMonth(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var fecha = LocalDate.of(2020,5,12)
        var quilmes = Location("Quilmes", "Buenos Aires", 12000, false)
        var project2  = Project("ProjectQuilmes",fecha!!, LocalDate.of(2020,7,8), quilmes!!)


        user!!.collaboratesOnAProject(project2!!,100, LocalDate.of(2020,5,12))
        user!!.collaboratesOnAProject(project2!!,300, LocalDate.of(2020,5,15))


        Assert.assertEquals(user!!.points,800)
    }
    @Test
    fun givenAProjectINotifyitsDonorUsersThatItEnded() {

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        var fecha = LocalDate.of(2020,5,12)
        var project   = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)


        user!!.collaboratesOnAProject(project!!, 400, LocalDate.of(2015, 5, 3))
        project!!.notifyDonorsThatTheProjectHasEnded()

        Assert.assertEquals(user!!.listOfClosedProjects.size,1)

    }

   @Test
    fun IThrowAnExceptionWhenIWantToCheckIfAProjectIsFinishedAndIAmNotAnAdministrator(){

       var user = User("Lara","laraA@gmail.com","lara", false,"ara")
       var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
       var fecha = LocalDate.of(2020,5,12)
       var project   = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)

       user!!.collaboratesOnAProject(project!!,400, LocalDate.of(2015,5,3))

         assertThrows<Exception> { user!!.projectFinished(project!!)}
    }

    @Test
    fun aUserWhoIsAnAdministratorNotifiesThaTheProjectEnded(){

        var userAdministrator = User("tomas","tomasA@gmail.com","lara", true,"ara")
        var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        var dateI     = LocalDate.of(2020, 5, 1)
        var todayDate = LocalDate.now()
        var project3  = Project("Project2", dateI!!,todayDate!!,bernal!!)



        userAdministrator!!.collaboratesOnAProject(project3!!,6000000, LocalDate.of(2015,5,3))
        userAdministrator!!.projectFinished(project3!!)

        Assert.assertEquals(userAdministrator!!.listOfClosedProjects.size,1)
    }

    @Test
    fun userHasTheTop10Available(){

        var aplication = Aplication()
        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        var fecha = LocalDate.of(2020,5,12)
        var project   = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)

        aplication.userRegister(user!!)
        aplication.addProjects(project!!)
        aplication.cambiarFecha(LocalDate.now())

        Assert.assertEquals("the top 10 are already available", user!!.cambio)
    }

}