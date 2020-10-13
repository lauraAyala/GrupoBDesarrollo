package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface UserService {

    fun createUser(user: User)
    fun updateUser(user: User)
    fun recoverUser(id:Long): User
    fun allDonation(user: User): MutableList<Donor>
}