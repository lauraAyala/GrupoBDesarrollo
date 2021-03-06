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


    @Query(value = "SELECT location.name, location.province, location.population, location.stateConective" +
            "FROM location " +
            "JOIN location.listDonations d as d" +
            "FULL JOIN donor  ON l.id = location.id" ,nativeQuery = true)
    fun top10Locations(): MutableList<Location>

}