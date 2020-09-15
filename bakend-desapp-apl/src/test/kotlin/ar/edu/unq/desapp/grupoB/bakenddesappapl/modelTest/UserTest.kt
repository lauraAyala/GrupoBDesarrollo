package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class UserTest {

    lateinit var user: User
    lateinit var bernal : Location
    lateinit var fecha : LocalDate
    lateinit var project : Project


    @Before
    fun setUp(){


        user = User("Lara","laraA@gmail.com","lara", false,"ara")
        bernal = Location("Bernal", "Buenos Aires", 1000, false)
        fecha = LocalDate.of(2020,5,12)
        project = Project("ProjectInitial", 10, fecha, bernal!!)

    }

    @Test
    fun AUserIsCreatedAndYourNameIsVerified(){

        Assert.assertEquals(user.nameUser,"Lara")

    }

    @Test
    fun AUserIsCreatedAndYourEmailIsVerified(){

        Assert.assertEquals(user.email,"laraA@gmail.com")

    }

    @Test
    fun AUserIsCreatedAndYourPasswordIsVerified(){

        Assert.assertEquals(user.password,"lara")

    }

    @Test
    fun AUserIsCreatedAndYourNickNameIsVerified(){

        Assert.assertEquals(user.nickName,"ara")

    }

    @Test
    fun AUserIsCreatedAndVerifiedIfYouAreAnAdministrator(){

        Assert.assertEquals(user.isAdmin,false)

    }

    @Test
    fun AUserIsCreatedWithoutPointsAndVerified(){

        Assert.assertEquals(user.points,0)

    }

    @Test
    fun AuserCollaboratesOnAProject(){

        user.collaboratesOnAProject(project,1200,Month.MAY)

        Assert.assertEquals(user.points,1700)

    }

}