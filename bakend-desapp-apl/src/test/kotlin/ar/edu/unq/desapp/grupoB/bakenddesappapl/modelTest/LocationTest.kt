package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocationTest {

    @Test
    fun ALocationIsCreatedAndYourNameIsVerified(){

        var location    = Location("Bernal","Buenos Aires",70,false)


        Assert.assertEquals(location!!.name,"Bernal")
    }

    @Test
    fun ALocationIsCreatedAndYourProvinceIsVerified(){

        var location    = Location("Bernal","Buenos Aires",70,false)

        Assert.assertEquals(location!!.province,"Buenos Aires")
    }

    @Test
    fun ALocationIsCreatedAndYourPopulationIsVerified(){

        var location    = Location("Bernal","Buenos Aires",70,false)

        Assert.assertEquals(location!!.population,70)
    }

    @Test
    fun ALocationIsCreatedAndYouStateConectiveVerified(){

        var location    = Location("Bernal","Buenos Aires",70,false)

        Assert.assertEquals(location!!.stateConective,false)
    }

    @Test
    fun verifyThatMyLocationHasTwoDonations(){

        var user = User("Lara","laraA@gmail.com","lara", false,"ara")
        var user2 = User("Isaias","isa@gmail.com","isaias", false,"ara")

        var location    = Location("Bernal","Buenos Aires",70,false)
        var donorPepe   = Donor(user, 1000, LocalDate.of(2020,4,11))
        var  donorIsaias = Donor(user2, 500, LocalDate.of(2020,4,11))

        location!!.donorRegister(donorPepe!!)
        location!!.donorRegister(donorIsaias!!)

        Assert.assertEquals(location!!.listDonation.size,2)

    }

    @Test
    fun verifyThatCollectionOfAnLocation(){

        var location    = Location("Bernal","Buenos Aires",70,false)

        Assert.assertEquals(0,location!!.collection)

    }
}