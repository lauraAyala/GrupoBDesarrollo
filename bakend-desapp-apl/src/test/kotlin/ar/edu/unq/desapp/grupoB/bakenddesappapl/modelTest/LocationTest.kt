package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
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

        var location    = Location("Bernal","Buenos Aires",70,false)
        var donorPepe   = Donor("pepe", 1000, LocalDate.of(2020,4,11))
        var  donorIsaias = Donor("Isaias", 500, LocalDate.of(2020,4,11))

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