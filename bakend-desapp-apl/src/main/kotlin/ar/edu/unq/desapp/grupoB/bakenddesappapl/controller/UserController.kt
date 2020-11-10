package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserService
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

    @GetMapping("/user/{id}")
    fun findById(@PathVariable id: Int) = userService.recoverUser(id.toLong())

    @GetMapping("/users")
    fun getAll() = userService.allUsers()

    @DeleteMapping("/delete/{name}")
    fun deleteByName(@PathVariable name: String?): List<User>? {
        return userService.deleteUserByName(name)
    }

    @PostMapping("/login")
    fun login(@RequestParam email:String, @RequestParam password:String): ResponseEntity<User>{

        val user = userService.login(email,password)

        return ResponseEntity(user, HttpStatus.CREATED)
    }
    /*
    @PostMapping("/makeDonation")
    fun makeDonation( user: User, project: Project, donorUser: Int, date: LocalDate): ResponseEntity<Unit> {
        val user = userService.makeDonation(user,project, donorUser, date)
        return  ResponseEntity(user,HttpStatus.OK)
    }*/


}