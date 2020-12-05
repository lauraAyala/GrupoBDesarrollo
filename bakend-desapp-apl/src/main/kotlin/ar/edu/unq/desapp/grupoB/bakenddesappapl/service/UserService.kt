package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.DonationDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.UserDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var projectRepository: ProjectRepository

    @Autowired
    lateinit var donorRepository: DonationRepository

   // @Autowired
   // lateinit var jWTTokenService: JWTTokenService


    fun createUser(user: User): User {

        val user = userRepository.save(user)

        return user

    }
    fun updateUser(user: User){

        userRepository.saveAndFlush(user)

    }
    fun recoverUser(id: Long): User{

        return userRepository.getOne(id)

    }
    fun allDonation(user: String): MutableList<Donor>{

      val donors = donorRepository.findAll()
        var donations: MutableList<Donor> =  mutableListOf()

        for (d in donors){

            if(d.userD?.nameUser == user){

                donations.add(d)

            }
        }

        return donors

    }


    fun allUsers(): MutableList<User> {

        return userRepository.findAll()

    }
    fun deleteUserByName(name: String?): MutableList<User> {
        userRepository.deleteByName(name)
        return this.allUsers()
    }

    fun login(email: String, password: String): UserDTO {

        try {
          var  user  = userRepository.login(email, password)
            val userDto = UserDTO(user?.nameUser!!,user.listDonor,user.points)



           /*val token: String = jWTTokenService.getJWTToken(user?.nameUser)
            user?.tokend = token*/
            return userDto

        }
        catch ( e:Exception) {
            throw Exception("the email or password is incorrect");
        }
    }

    fun makeDonation(user: String,project: String, amount: Int, date: LocalDate) : UserDTO {

        // var projectRecover = projectRepository.findById(project.id!!.toLong())
        //var userUpdate = userRepository.findById(user.id!!.toLong())
       // var projectRecover = projectRepository.getOne(project.toLong())
       // println(projectRecover)
       // var userUpdate = this.recoverUser(user.toLong())
       // println(userUpdate)
       // userUpdate.collaboratesOnAProject(projectRecover, donorUser, date)
        //var donor = Donor(userUpdate, donorUser, date)
        //val donorRecover = DonationDTO(donor.nickName!!,projectRecover.nameProject!!,donorUser)

       // return donorRecover
        var projectRecover  = this.projectRepository.recoverProject(project)
        var userUpdate = this.userRepository.recoverUser(user)

          var donor =  userUpdate!!.collaboratesOnAProject(projectRecover,amount, date)
        println(donor)
        projectRecover =  this.projectRepository.saveAndFlush(projectRecover)
        println(projectRecover)
          this.userRepository.saveAndFlush(userUpdate)
       // var donor = Donor(userUpdate.nickName!!, donorUser, date)

          this.donorRepository.save(donor)

        val userDto = UserDTO(user,userUpdate.listDonor,userUpdate.points)
        val donorDto = DonationDTO(donor.nickName!!,projectRecover.nameProject!!,amount)

        return  userDto
    }

    fun profile(name: String): UserDTO? {

       val userRecover = userRepository.recoverUser(name)

        val user = UserDTO(userRecover?.nameUser!!,userRecover.listDonor,userRecover.points)

        return (user)

    }

    fun finishedProject(nameProject: String, nameUser: String) {

        var project = this.projectRepository.recoverProject(nameProject)
        var user = this.userRepository.recoverUser(nameUser)
        println(project)
        println(user)

        user?.projectFinished(project)


    }


}
