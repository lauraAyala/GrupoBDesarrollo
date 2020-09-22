package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocationTest {

     var location: Location?  = null
     var donorPepe: Donor?    = null
     var donorIsaias: Donor?  = null

    @BeforeEach
    fun setUp(){

        donorPepe   = Donor("pepe", 1000, LocalDate.of(2020,4,11))
        donorIsaias = Donor("Isaias", 500, LocalDate.of(2020,4,11))
        location    = Location("Bernal","Buenos Aires",70,false)
    }

    @Test
    fun ALocationIsCreatedAndYourNameIsVerified(){

        Assert.assertEquals(location!!.name,"Bernal")
    }

    @Test
    fun ALocationIsCreatedAndYourProvinceIsVerified(){

        Assert.assertEquals(location!!.province,"Buenos Aires")
    }

    @Test
    fun ALocationIsCreatedAndYourPopulationIsVerified(){

        Assert.assertEquals(location!!.population,70)
    }

    @Test
    fun ALocationIsCreatedAndYouStateConectiveVerified(){

        Assert.assertEquals(location!!.stateConective,false)
    }

    @Test
    fun verifyThatMyLocationHasTwoDonations(){
        location!!.donorRegister(donorPepe!!)
        location!!.donorRegister(donorIsaias!!)

        Assert.assertEquals(location!!.listDonation.size,2)

    }

    @Test
    fun verifyThatCollectionOfAnLocation(){

        Assert.assertEquals(0,location!!.collection)

    }
}