package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller


import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
@RestController
@RequestMapping("/project")
class ProjectController(val projectService: ProjectService) {

    @PostMapping("/registerProject")
    fun createdProject(@Valid @RequestBody project: Project) : ResponseEntity<Project> {

        val p = projectService.createdProject(project)

        return  ResponseEntity(projectService.recoverProject(p.id!!), HttpStatus.CREATED)

    }

    @GetMapping("/projects")
    fun getAll() = projectService.allProjects()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) = projectService.recoverProject(id.toLong())

    /*@GetMapping("/top10localitations")
    fun top10Localitations() = projectService.top10localitations()*/

    @GetMapping("/openProjects")
    fun listOpentProjects() = projectService.listOpenProject()

    @GetMapping("/upcomingProjectsToClose")
    fun listUpcomingProjectsToClose() = projectService.listUpcomingProjectsToClose()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?>? {
        val errors: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
        return errors
    }

}

