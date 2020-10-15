package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateDonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateLocationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DataServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DonorServiceImpl
import org.junit.Assert
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LocationServiceTest {

   /* var daoDonor =  HibernateDonorDao()
    var serviceDonor = DonorServiceImpl(daoDonor,DataServiceImpl())
    var dao = HibernateLocationDao()
    var service = LocationServiceImpl(dao,DataServiceImpl())


    @Test
    fun createdAnLocationAnRecover(){

        var location =  Location("Bernal","Buenos Aires", 2000, false)
        service.createdLocation(location)

        Assert.assertEquals("Bernal",service.recoverLocation(location.id!!).name)
        Assert.assertEquals("Buenos Aires",service.recoverLocation(location.id!!).province)
        Assert.assertEquals(2000,service.recoverLocation(location.id!!).population)
        Assert.assertEquals(false,service.recoverLocation(location.id!!).stateConective)

    }

    @Test
    fun registerDonorAnLocation(){

        var donor = Donor("lau",300, LocalDate.of(2020,4,16))
        serviceDonor.createdDonation(donor)
        donor = serviceDonor.recoverDonor(1)

        var location =  Location("Quilmes","Buenos Aires", 2000, false)
        location = service.createdLocation(location)
       // location = service.recoverLocation(1)
        service.registerDonor(location,donor)
        println(location)

        Assert.assertEquals(1,location.listDonation.size)

    }

    @Test
    fun allLocations() {
        var berazategui = Location("Berazateui", "Buenos Aires", 2000, false)
        berazategui = service.createdLocation(berazategui)
        var ezpeleta = Location("Ezpeleta", "Buenos Aires", 2000, false)
        ezpeleta = service.createdLocation(ezpeleta)

        Assert.assertEquals(3,service.allLoctions().size)
        Assert.assertTrue(service.allLoctions().any { it.name == "Berazateui" })
        Assert.assertTrue(service.allLoctions().any { it.name == "Ezpeleta" })

    }*/

}