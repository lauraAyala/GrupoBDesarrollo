package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller


import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/project")
class ProjectController(val projectService: ProjectService) {

    @PostMapping("/registerProject")
    fun createdProject(@RequestBody project: Project) : ResponseEntity<Project> {

        val p = projectService.createdProject(project)

        return  ResponseEntity(projectService.recoverProject(p.toString().toLong()), HttpStatus.CREATED)

    }

    @GetMapping("/projects")
    fun getAll() = projectService.allProjects()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) = projectService.recoverProject(id.toLong())

}

