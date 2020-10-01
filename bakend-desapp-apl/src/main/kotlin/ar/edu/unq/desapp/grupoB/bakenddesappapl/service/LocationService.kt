package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location

interface LocationService {

    fun createdLocation(location: Location)
    fun updateLocation(location: Location)
    fun recoverLocation(name:String): Location
    fun registerDonor(donor: Donor)
    fun allDonations(): ArrayList<Donor>
}