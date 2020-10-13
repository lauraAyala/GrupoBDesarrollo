package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import javax.persistence.Id

interface ProjectDao{

    fun createdProject(project: Project):Int
    fun recoverProject(id: Long) : Project
    fun updateProject(project: Project)
    fun allProjects():MutableList<Project>

}