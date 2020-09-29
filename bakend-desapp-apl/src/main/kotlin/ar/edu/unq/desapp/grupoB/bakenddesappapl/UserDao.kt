package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface UserDao {

    fun createUser(user: User)
    fun update(user: User)
    fun recover(name: String): User
    fun addDonation(donor: Donor)

}