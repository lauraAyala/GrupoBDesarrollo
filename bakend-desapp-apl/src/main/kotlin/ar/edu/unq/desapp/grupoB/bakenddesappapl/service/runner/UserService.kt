package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface UserService {

    fun createUser(user: User)
    fun updateUser(user: User)
    fun recover(id:Long): User
    fun addDonation(donor: Donor)
}