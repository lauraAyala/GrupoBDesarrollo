package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.LocationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.LocationService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService

class LocationServiceImpl(private val locationDAO: LocationDao,
                          private val dataDAO: DataDAO) : LocationService {
    override fun createdLocation(location: Location) {
        TODO("Not yet implemented")
    }

    override fun updateLocation(location: Location) {
        TODO("Not yet implemented")
    }

    override fun recoverLocation(name: String): Location {
        TODO("Not yet implemented")
    }

    override fun registerDonor(donor: Donor) {
        TODO("Not yet implemented")
    }

    override fun allDonations(): ArrayList<Donor> {
        TODO("Not yet implemented")
    }
}