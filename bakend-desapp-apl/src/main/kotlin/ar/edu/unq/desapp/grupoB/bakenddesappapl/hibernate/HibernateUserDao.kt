package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner

class HibernateUserDao : HibernateDAO<User>(User::class.java),UserDao {
    override fun createUser(user: User): Int {

        this.save(user)

        return (this.recover(user.id!!.toLong()).id!!.toInt())
    }

    override fun updateUser(user: User) {
        val session = TransactionRunner.currentSession

        session.saveOrUpdate(user)
    }

    override fun recover(id:Long): User {

        return (this.recover(id))
    }

    override fun addDonation(donor: Donor) {
        TODO("Not yet implemented")
    }
}