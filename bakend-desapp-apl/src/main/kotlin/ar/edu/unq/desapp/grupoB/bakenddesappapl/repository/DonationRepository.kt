package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonationRepository: JpaRepository<Donor, Long> {

}