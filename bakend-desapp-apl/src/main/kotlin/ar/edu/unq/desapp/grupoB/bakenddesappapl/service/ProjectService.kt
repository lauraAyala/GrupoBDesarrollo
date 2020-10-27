package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {

    @Autowired
    lateinit var repository : ProjectRepository

    fun createdProject(project: Project): Project {

       return repository.save(project)


   }
    fun recoverProject(id: Long) : Project{

        return repository.getOne(id)
    }

    fun updateProject(project: Project){

        repository.saveAndFlush(project)
    }

    fun allProjects(): MutableList<Project>{

        return repository.findAll()
    }

    fun top10localitations(): MutableList<Location> {

       return  repository.top10Localitations()
    }
}