package ar.edu.unq.desapp.grupoB.bakenddesappapl.dto

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import java.time.LocalDate

class ProjectDTO(val id:Long, val nameProject: String, val location: String, val initDate: LocalDate, val endDate:LocalDate) {
}