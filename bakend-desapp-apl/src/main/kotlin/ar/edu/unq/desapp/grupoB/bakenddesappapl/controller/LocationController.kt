package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.LocationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/location")
class LocationController(val locationService: LocationService) {

    @PostMapping("/registerlocation")
    fun createdProject(@RequestBody location: Location) : ResponseEntity<Location> {

        val l= locationService.createdLocation(location)

        return  ResponseEntity(locationService.recoverLocation(l.id!!), HttpStatus.CREATED)

    }

    @GetMapping("/location/{id}")
    fun findById(@PathVariable id: Int) = locationService.recoverLocation(id.toLong())

    @GetMapping("/locations")
    fun getAll() = locationService.allLoctions()

    @GetMapping("/top10donations")
    fun top10Donations() = locationService.top10Donations()
}