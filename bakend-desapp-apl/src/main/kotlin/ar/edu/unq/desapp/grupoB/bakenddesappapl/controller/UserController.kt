package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass.DonationRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass.LoginRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.DonationDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.UserDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.PasswordAuthentication

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @PostMapping("/registerUser")
    fun createdUser(@RequestBody user: User) : ResponseEntity<User> {

        val u= userService.createUser(user)

        return  ResponseEntity(userService.recoverUser(u.toLong()), HttpStatus.CREATED)

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) = userService.recoverUser(id.toLong())

    @GetMapping("/users")
    fun getAll() = userService.allUsers()

    @DeleteMapping("/delete/{name}")
    fun deleteByName(@PathVariable name: String?): List<User>? {
        return userService.deleteUserByName(name)
    }

    @GetMapping("/login")
    fun login(@RequestBody login : LoginRequest): ResponseEntity<UserDTO>{

        val user = userService.login(login.email,login.password)

        return ResponseEntity(user, HttpStatus.OK)
    }
    @PostMapping("/makeDonation")
<<<<<<< HEAD
    fun makeDonation(@RequestBody donationRequest : DonationRequest) : ResponseEntity<Int> {
=======
    fun makeDonation(@RequestBody donationRequest : DonationRequest) : ResponseEntity<DonationDTO> {
>>>>>>> 4b3e0c1247ba80a9f5cb5851301fafa2e5eb662c




        //val user = userService.makeDonation(donationRequest.user,donationRequest.project,donationRequest.donorUser,donationRequest.date)
       var donor = userService.makeDonation(donationRequest)

        return  ResponseEntity( donor, HttpStatus.OK)
    }



}
