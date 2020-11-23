package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DonorTests {

    @Test
    fun aNewDonationIsCreatedAndTheDataIsVerifiedToBeCorrect(){

        var user = User("Pedro","pepe@gmail.com","pepe",false,"pepe")

        var donor = Donor(user, 1000, LocalDate.of(2020,4,11))


        Assert.assertEquals(donor!!.nickName, "pepe")
        Assert.assertEquals(donor!!.donation, 1000)
        Assert.assertEquals(donor!!.date, LocalDate.of(2020,4,11))


    }
}