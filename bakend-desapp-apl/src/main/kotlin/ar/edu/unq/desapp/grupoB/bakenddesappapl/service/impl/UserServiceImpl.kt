package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.UserService

class UserServiceImpl(private val userDAO: UserDao,
                      private val dataDAO: DataDAO) : UserService {
    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun update(user: User) {
        TODO("Not yet implemented")
    }

    override fun recover(name: String): User {
        TODO("Not yet implemented")
    }

    override fun addDonation(donor: Donor) {
        TODO("Not yet implemented")
    }
}
