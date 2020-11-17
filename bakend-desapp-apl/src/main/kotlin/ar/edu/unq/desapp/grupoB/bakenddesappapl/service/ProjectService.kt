package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.dto.ProjectDTO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.LocationRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {

    @Autowired
    lateinit var repository : ProjectRepository

    @Autowired
    lateinit var repositoryLocation : LocationRepository

    fun createdProject(project: Project): Project {

        val location = repositoryLocation.save(project.locationP!!)
        val newProject = Project(project.nameProject!!,project.dateInit!!,project.dateEnd!!,location)



       return repository.save(newProject)

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

    fun listOpenProject(): MutableList<ProjectDTO> {

        val projects = this.allProjects()

        var openProjects : MutableList<ProjectDTO> = mutableListOf()

        for (p :Project in projects){

            if (!p.itsProjectEndDate()){

                var projectDTO = ProjectDTO(p.id!!,p.nameProject!!,p.locationP?.name!!,p.dateInit!!,p.dateEnd!!)

                openProjects.add(projectDTO)
            }
        }

        return openProjects
    }

    /* fun top10localitations(): MutableList<Location> {

         var locationsRes: MutableList<Location> = mutableListOf()

         var locations = repository.top10Localitations()

         for(l: Location in locations){

             var location = Location(l.name!!,l.province!!,l.population!!,l.stateConective!!)

             locationsRes.add(location)
         }

        return  locationsRes
     }*/
}