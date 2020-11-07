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

    fun top10Donations(): MutableList<Donor> {

        var donations = locationRepository.top10Donations()
        var res : MutableList<Donor> = mutableListOf()

        for (d : Donor in donations){

            var donor = Donor(d.nickName!!,d.donation!!,d.date!!)

            res.add(donor)

        }
        return res

    }

    fun top10Locations(): MutableList<Location> {

       return locationRepository.top10Locations()
    }
}