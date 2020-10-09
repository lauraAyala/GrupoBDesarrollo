package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface UserDao {

    fun createUser(user: User): Int
    fun updateUser(user: User)
    fun recover(id:Long): User
    fun addDonation(donor: Donor)

}