package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface LocationRepository : JpaRepository<Location, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM locality WHERE name = :locality_name", nativeQuery = true)

    fun deleteByName(@Param("locality_name") locality_name: String?): Int?

    @Query(value = " SELECT donor.nickName, donor.donation, donor.date " +
            "FROM location.listDonation as d " + " FULL JOIN donor  ON d.id = donor.id " +
            "ORDER BY donor.donation " + " DESC " +
            "LIMIT 10",nativeQuery = true)
    fun top10Donations(): MutableList<Donor>

    @Query(value = "SELECT location.name, location.province, location.population, location.stateConective" +
            "FROM location " +
            "FULL JOIN project.locationP as l ON l.id = location.id" ,nativeQuery = true)
    fun top10Locations(): MutableList<Location>

}