package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {

}