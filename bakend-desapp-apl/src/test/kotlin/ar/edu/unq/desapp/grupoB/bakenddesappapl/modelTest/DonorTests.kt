package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DonorTests {
    var donor: Donor? = null

    @BeforeEach
    fun setUp() {
        donor = Donor("pepe", 1000, LocalDate.of(2020,4,11))
    }

    @Test
    fun aNewDonationIsCreatedAndTheDataIsVerifiedToBeCorrect(){
        Assert.assertEquals(donor!!.nickName, "pepe")
        Assert.assertEquals(donor!!.donation, 1000)
        Assert.assertEquals(donor!!.date, LocalDate.of(2020,4,11))


    }
}