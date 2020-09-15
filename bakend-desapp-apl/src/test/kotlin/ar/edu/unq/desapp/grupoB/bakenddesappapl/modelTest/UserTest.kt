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
    lateinit var quilmes : Location
    lateinit var fecha : LocalDate
    lateinit var project : Project
    lateinit var project2 : Project



    @Before
    fun setUp(){


        user = User("Lara","laraA@gmail.com","lara", false,"ara")
        bernal = Location("Bernal", "Buenos Aires", 1000, false)
        quilmes = Location("Quilmes", "Buenos Aires", 12000, false)

        fecha = LocalDate.of(2020,5,12)
        project = Project("ProjectInitial", 10, fecha, bernal!!)
        project2 = Project("ProjectQuilmes", 11, fecha, quilmes!!)

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
    fun AuserCollaboratesOnAProjectWithMoreThan1000(){

        user.collaboratesOnAProject(project,1200, LocalDate.of(2020,5,12))

        Assert.assertEquals(user.points,1200)

    }

    @Test
    fun AuserCollaboratesOnAProjectWithMoreThan2000Inhabitant(){

        user.collaboratesOnAProject(project2,100, LocalDate.of(2020,5,12))

        Assert.assertEquals(user.points,200)

    }

    @Test
    fun collaborateOnAProjectTwiceInTheSameMonth(){

        user.collaboratesOnAProject(project2,100, LocalDate.of(2020,5,12))
        user.collaboratesOnAProject(project2,300, LocalDate.of(2020,5,12))


        Assert.assertEquals(user.points,800)

    }

}