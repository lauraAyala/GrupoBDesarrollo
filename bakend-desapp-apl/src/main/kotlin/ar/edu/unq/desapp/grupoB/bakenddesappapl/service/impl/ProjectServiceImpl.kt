package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner.runTrx

class ProjectServiceImpl( private val projectDAO: ProjectDao,
                          private val dataDAO: DataDAO) : ProjectService {
    override fun createdProject(project: Project) {

        return runTrx{ projectDAO.createdProject(project)}
    }

    override fun recoverProject(id: Long): Project {

        return  runTrx { projectDAO.recoverProject(id) }

    }

    override fun updateProject(project: Project) {
        return runTrx { projectDAO.updateProject(project) }
    }


}