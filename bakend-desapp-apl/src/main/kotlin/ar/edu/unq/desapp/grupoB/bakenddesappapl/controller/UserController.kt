package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/user")
class UserController(val userService: UserService ) {

    @PostMapping("/registerUser")
    fun createdUser(@RequestBody user: User) : ResponseEntity<User> {

        val u= userService.createUser(user)

        return  ResponseEntity(userService.recoverUser(u.toLong()), HttpStatus.CREATED)

    }

    @GetMapping("/user/{id}")
    fun findById(@PathVariable id: Int) = userService.recoverUser(id.toLong())

    @GetMapping("/users")
    fun getAll() = userService.allUsers()

}