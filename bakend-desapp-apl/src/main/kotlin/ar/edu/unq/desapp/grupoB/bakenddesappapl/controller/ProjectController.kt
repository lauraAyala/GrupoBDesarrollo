package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDto
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.ProjectService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin
//@ServiceREST
@RequestMapping("/project")
class ProjectController(val projectService: ProjectService) {

   /* @PostMapping
    fun createdProject(@RequestBody projectDto: ProjectDto) = projectService.createdProject(projectDto.name)*/

}

