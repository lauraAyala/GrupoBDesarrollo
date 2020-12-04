package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass.DonationRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass.LoginRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.DonationDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.UserDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.FinishedProjectRequest
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.UserService
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @PostMapping("/registerUser")
    fun createdUser(@Valid @RequestBody user: User) : ResponseEntity<User> {

         val user = userService.createUser(user)

        return  ResponseEntity(user,HttpStatus.CREATED)

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) = userService.recoverUser(id.toLong())

    @GetMapping("/users")
    fun getAll() = userService.allUsers()

    @DeleteMapping("/delete/{name}")
    fun deleteByName(@PathVariable name: String?): List<User>? {
        return userService.deleteUserByName(name)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody login: LoginRequest): ResponseEntity<UserDTO>{

        val user = userService.login(login.email, login.password)

        return ResponseEntity(user,HttpStatus.OK)
    }
    @PostMapping("/makeDonation")

    fun makeDonation(@Valid @RequestBody donationRequest: DonationRequest) : ResponseEntity<UserDTO> {
        val date = LocalDate.now()
        println(date)
        //val user = userService.makeDonation(donationRequest.user,donationRequest.project,donationRequest.donorUser,donationRequest.date)
       var user = userService.makeDonation(donationRequest.user!!, donationRequest.project,donationRequest.donorUser, date )



        return  ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping("/profile/{name}")
    fun profile(@PathVariable name: String) : ResponseEntity<UserDTO>{

       val user = userService.profile(name)

        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping("/finishedProject")
    fun finishedProject(@RequestBody finishedProject: FinishedProjectRequest): ResponseEntity<HttpStatus>{

        userService.finishedProject(finishedProject.nameProject,finishedProject.nameUser)

        return ResponseEntity(HttpStatus.OK)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?>? {
        val errors: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
        return errors
    }

}
