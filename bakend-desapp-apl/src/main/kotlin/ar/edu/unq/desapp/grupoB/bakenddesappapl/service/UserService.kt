package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass.DonationRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.DonationDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.UserDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var projectRepository: ProjectRepository

    @Autowired
    lateinit var donorRepository: DonationRepository


    fun createUser(user: User){

        userRepository.save(user)

        //return user.id!!.toInt()

    }
    fun updateUser(user: User){

        userRepository.saveAndFlush(user)

    }
    fun recoverUser(id: Long): User{

        return userRepository.getOne(id)

    }
    fun allDonation(user: User): MutableList<Donor>{

      //  var userUpdate = userRepository.getOne(user.id!!.toLong())
        return user.listDonor

    }


    fun allUsers(): MutableList<User> {

        return userRepository.findAll()

    }
    fun deleteUserByName(name: String?): MutableList<User> {
        userRepository.deleteByName(name)
        return this.allUsers()
    }

    fun login(email: String, password: String) {

        userRepository.login(email,password)
        //val userDto = UserDTO(user?.nameUser!!,user?.email!!,user?.nickName!!, user?.points!!)

    }

    fun makeDonation(donationRequest: DonationRequest) : DonationDTO {

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
        var projectRecover  = this.projectRepository.recoverProject(donationRequest.project)
        var userUpdate = this.userRepository.recoverUser(donationRequest.user)

          var donor =  userUpdate!!.collaboratesOnAProject(projectRecover,donationRequest.donorUser, donationRequest.date)
          projectRecover =  this.projectRepository.saveAndFlush(projectRecover)
          this.userRepository.saveAndFlush(userUpdate)
       // var donor = Donor(userUpdate.nickName!!, donorUser, date)

          this.donorRepository.save(donor)

        val donorDto = DonationDTO(donor.nickName!!,projectRecover.nameProject!!, donationRequest.donorUser)

        return  donorDto
    }

    fun profile(name: String): UserDTO? {

       val userRecover = userRepository.recoverUser(name)

        val user = UserDTO(userRecover?.nameUser!!,userRecover.listDonor,userRecover.points)

        return (user)

    }

    fun finishedProject(nameProject: String, nameUser: String) {

        var project = this.projectRepository.recoverProject(nameProject)
        var user = this.userRepository.recoverUser(nameUser)

        user?.projectFinished(project)


    }


}
