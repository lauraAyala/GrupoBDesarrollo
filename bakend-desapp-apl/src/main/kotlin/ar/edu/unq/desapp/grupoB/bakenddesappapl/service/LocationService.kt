package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.LocationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationService {

    @Autowired
    lateinit var locationRepository : LocationRepository

    fun createdLocation(location: Location): Location{

        return locationRepository.save(location)
    }

    fun updateLocation(location: Location){

        locationRepository.saveAndFlush(location)
    }
    fun recoverLocation(id: Long): Location{

        return locationRepository.getOne(id)
    }
    fun registerDonor(location: Location,donor: Donor){

        location.donorRegister(donor)
    }
    fun allDonations(location: Location): MutableList<Donor>{

        return location.listDonation
    }
    fun allLoctions(): MutableList<Location>{

        return locationRepository.findAll()
    }



    fun top10Locations(): MutableList<Location> {


        var locations = locationRepository.findAll()
        var top10locations : MutableList<Location> = mutableListOf()

        locations.sortBy { it.lastDonationOfLocation().date}
        locations.reverse()
        var contador : Int = 10
        for (l :Location in locations){

            if (contador > 0){

                top10locations.add(l)
                contador -= 1
            }
        }
       return top10locations
    }
}