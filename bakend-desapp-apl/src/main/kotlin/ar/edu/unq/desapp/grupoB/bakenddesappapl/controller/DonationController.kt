package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.DonationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping as PostMapping1

@RestController
@RequestMapping("/donation")
class DonationController(val donationService: DonationService) {
    
    @PostMapping1("/registerDonation")
    fun  createdDonation(@RequestBody donation: Donor) : ResponseEntity<Donor>{
        val d = donationService.createdDonation(donation)
        return ResponseEntity(donationService.recoverDonation(d.toString().toLong()), HttpStatus.CREATED)
    }
}
