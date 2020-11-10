package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*


@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var projectRepository: ProjectRepository

    @Autowired
    lateinit var donorRepository: DonationRepository


    fun createUser(user: User): Int{

        userRepository.save(user)

        return user.id!!.toInt()

    }
    fun updateUser(user: User){

        userRepository.saveAndFlush(user)

    }
    fun recoverUser(id: Long): User{

        return userRepository.getOne(id)

    }
    fun allDonation(user: User): MutableList<Donor>{

        var userUpdate = userRepository.getOne(user.id!!.toLong())
        return userUpdate.listDonor

    }
   fun collaboratesOnAProject(idUser: Long, project: Project, donorUser: Int, date: LocalDate){

       var projectRecover = projectRepository.getOne(project.id!!.toLong())
       var userUpdate = userRepository.getOne(idUser)

       userUpdate.collaboratesOnAProject(projectRecover, donorUser, date)

       userRepository.save(userUpdate)

   }

    fun allUsers(): MutableList<User> {

        return userRepository.findAll()

    }
    fun deleteUserByName(name: String?): MutableList<User> {
        userRepository.deleteByName(name)
        return this.allUsers()
    }

    fun login(email: String, password: String): User? {

      /* var user = userRepository.login(email,password)

        var  userRes = User(user?.nameUser!!,user.email!!, user.password!!,user.isAdmin!!,user.nickName!!)
       */
        return userRepository.login(email,password)

    }

   /* fun makeDonation(user: User, project: Project, donorUser: Int, date: LocalDate){

        // var projectRecover = projectRepository.findById(project.id!!.toLong())
        //var userUpdate = userRepository.findById(user.id!!.toLong())
        var projectRecover = projectRepository.getOne(project.id!!.toLong())
        var userUpdate = userRepository.getOne(user.id!!.toLong())
        userUpdate.collaboratesOnAProject(projectRecover,donorUser,date)


        userRepository.save(userUpdate)

    }*/
}