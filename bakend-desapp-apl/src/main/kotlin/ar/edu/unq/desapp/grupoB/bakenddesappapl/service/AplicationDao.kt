package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface AplicationDao {

    fun allUsers(): MutableList<User>
    fun allProjects(): MutableList<Project>
    fun top10Locations(): MutableList<Location>
    fun top10Donations(): MutableList<Donor>
    fun allLocations(): MutableList<Location>
}