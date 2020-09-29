package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project

interface ProjectDao{

    fun createdProject(project: Project)
    fun updateProject(project: Project)
}