package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.DonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateDataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateDonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.DonorService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DataServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DonorServiceImpl
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DonorServiceTest {

    val dao: DonorDao = HibernateDonorDao()
    var service = DonorServiceImpl(dao,DataServiceImpl())
    @Test
    fun createdAnDonor(){

        var donor = Donor("lau",300, LocalDate.now())
        service.createdDonation(donor)

        var res = service.recoverDonor(1)
         Assert.assertEquals("lau", res.nickName)

    }
}