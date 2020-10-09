package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner.runTrx
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.UserService

class UserServiceImpl(private val userDAO: UserDao,
                      private val dataDAO: DataDAO) : UserService {
    override fun createUser(user: User) {
        return runTrx{userDAO.createUser(user)}
    }

    override fun updateUser(user: User) {
        return runTrx { userDAO.updateUser(user) }
    }

    override fun recover(id:Long): User {
        return  runTrx { userDAO.recover(id) }
    }

    override fun addDonation(donor: Donor) {
        TODO("Not yet implemented")
    }
}
