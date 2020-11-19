package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ProjectRepository : JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

    @Query(value = "SELECT * FROM project WHERE name_Project = :name LIMIT 1",nativeQuery = true)
    fun recoverProject(@Param("name")project: String): Project


}
