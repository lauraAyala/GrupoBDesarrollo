package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
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

    fun createdProject(project: Project): String? {

        val location = repositoryLocation.save(project.locationP!!)
        val newProject = Project(project.nameProject!!,project.dateInit!!,project.dateEnd!!,location)



       return repository.save(newProject).nameProject

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