package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.LocationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/location")
class LocationController(val locationService: LocationService) {

    @PostMapping("/registerlocation")
    fun createdProject(@Valid @RequestBody location: Location) : ResponseEntity<Location> {

        val l= locationService.createdLocation(location)

        return  ResponseEntity(locationService.recoverLocation(l.id!!), HttpStatus.CREATED)

    }

    @GetMapping("/location/{id}")
    fun findById(@PathVariable id: Int) = locationService.recoverLocation(id.toLong())

    @GetMapping("/locations")
    fun getAll() = locationService.allLoctions()



    @GetMapping("/top10locations")
    fun top10Locations() = locationService.top10Locations()

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