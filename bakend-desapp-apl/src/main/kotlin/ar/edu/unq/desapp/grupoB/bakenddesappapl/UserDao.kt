package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import java.time.LocalDate

interface UserDao {

    fun createUser(user: User): Int
    fun updateUser(user: User)
    fun recoverUser(id:Long): User
    fun allDonation(user: User): MutableList<Donor>
   // fun collaboratesOnAProject(project: Project, donorUser: Int, date: LocalDate)

}