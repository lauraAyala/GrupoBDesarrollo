package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.AplicationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.AplicationService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner.runTrx

class AplicationServiceImpl (val dao: AplicationDao, val data: DataDAO): AplicationService {

    override fun allUsers(): MutableList<User> {

        return  runTrx{ dao.allUsers()}
    }

    override fun allProjects(): MutableList<Project> {

        return  runTrx{ dao.allProjects()}

    }

    override fun top10Locations(): MutableList<Location> {

        return  runTrx{ dao.top10Locations()}

    }

    override fun top10Donations(): MutableList<Donor> {

        return  runTrx{ dao.top10Donations()}

    }

    override fun allLocations(): MutableList<Location> {

        return  runTrx{ dao.allLocations()}

    }
}