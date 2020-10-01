package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService

class ProjectServiceImpl( private val projectDAO: ProjectDao,
                          private val dataDAO: DataDAO) : ProjectService {
    override fun createdProject(project: Project) {
        TODO("Not yet implemented")
    }

    override fun updateProject(project: Project) {
        TODO("Not yet implemented")
    }


}