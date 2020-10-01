package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project

interface ProjectService {

    fun createdProject(project: Project)
    fun updateProject(project: Project)
}