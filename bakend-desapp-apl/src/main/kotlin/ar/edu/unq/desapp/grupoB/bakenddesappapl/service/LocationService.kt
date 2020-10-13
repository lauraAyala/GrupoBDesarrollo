package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location

interface LocationService {

    fun createdLocation(location: Location): Location
    fun updateLocation(location: Location)
    fun recoverLocation(id: Long): Location
    fun registerDonor(location: Location,donor: Donor)
    fun allDonations(location: Location): MutableList<Donor>
    fun allLoctions(): MutableList<Location>
}