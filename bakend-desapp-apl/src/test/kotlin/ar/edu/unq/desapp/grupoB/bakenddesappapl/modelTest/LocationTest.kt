package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LocationTest {

    lateinit var location : Location

    @Before
    fun setUp(){

        location = Location("Bernal","Buenos Aires",70,false)
    }

    @Test
    fun ALocationIsCreatedAndYourNameIsVerified(){

        Assert.assertEquals(location.name,"Bernal")
    }

    @Test
    fun ALocationIsCreatedAndYourProvinceIsVerified(){

        Assert.assertEquals(location.province,"Buenos Aires")
    }

    @Test
    fun ALocationIsCreatedAndYourPopulationIsVerified(){

        Assert.assertEquals(location.population,70)
    }

    @Test
    fun ALocationIsCreatedAndYouStateConectiveVerified(){

        Assert.assertEquals(location.stateConective,false)
    }
}