package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.DonationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid
import org.springframework.web.bind.annotation.PostMapping as PostMapping1


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/donation")
class DonationController(val donationService: DonationService) {
    
    @PostMapping1("/registerDonation")
    fun  createdDonation(@Valid @RequestBody donation: Donor) : ResponseEntity<Donor>{
        val d = donationService.createdDonation(donation)
        return ResponseEntity(donationService.recoverDonation(d.id!!), HttpStatus.CREATED)
    }

    @GetMapping("/donations")
    fun allDonations() = donationService.allDonations()

    @GetMapping("/top10donations")
    fun top10Donations() = donationService.top10Donations()

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
