package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DonationRepository: JpaRepository<Donor, Long> {

    @Query(value = " SELECT * FROM donor ORDER BY donation  DESC LIMIT 10",nativeQuery = true)
    fun top10Donations(): MutableList<Donor>

}