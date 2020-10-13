package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.LocationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.LocationService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner.runTrx

class LocationServiceImpl(private val locationDAO: LocationDao,
                          private val dataDAO: DataDAO) : LocationService {
    override fun createdLocation(location: Location) : Location{


        return runTrx{locationDAO.createdLocation(location)}
    }

    override fun updateLocation(location: Location) {


        return runTrx{locationDAO.updateLocation(location)}

    }

    override fun recoverLocation(id: Long): Location {


        return runTrx{locationDAO.recoverLocation(id)}

    }

    override fun registerDonor(location:Location,donor: Donor) {



        return runTrx{locationDAO.registerDonor(location,donor)}


    }

    override fun allDonations(location: Location): MutableList<Donor> {


        return runTrx{locationDAO.allDonations(location)}

    }

    override fun allLoctions(): MutableList<Location> {

        return runTrx{locationDAO.allLocations()}

    }
}