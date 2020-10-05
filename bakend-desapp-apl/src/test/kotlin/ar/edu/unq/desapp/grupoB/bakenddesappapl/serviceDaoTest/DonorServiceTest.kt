package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateDonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DataServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DonorServiceImpl
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DonorServiceTest {

    val dao: DonorDao = HibernateDonorDao()
    var service = DonorServiceImpl(dao,DataServiceImpl())

    @Test
    fun createdAnDonor(){

        var donor = Donor("lau",300, LocalDate.now())
        var id = service.createdDonation(donor)
        var donorRecover = service.recoverDonor(1)

         Assert.assertEquals( "lau", donorRecover.nickName)
        Assert.assertEquals( 300, donorRecover.donation)


    }
}