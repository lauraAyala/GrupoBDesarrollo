package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import java.time.LocalDate

class ProjectDto(val name: String, val dateInit: LocalDate, val dateEnd: LocalDate, val location: Location ) {

    /*companion object {
        fun from(project:Project) = {
                    ProjectDto(project.nameProject!!,
                            project.dateInit!!,
                            project.dateEnd!!, project.locationP!!)
                }
    }*/
}

