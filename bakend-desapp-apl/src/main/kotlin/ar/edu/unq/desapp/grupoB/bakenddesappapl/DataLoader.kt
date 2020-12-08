package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.LocationRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.ProjectRepository
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataLoader(userRepository: UserRepository) : ApplicationRunner {
    @Autowired
    private val userRepository: UserRepository

    @Autowired
    private val locationRepository: LocationRepository? = null

    @Autowired
    private val projectRepository: ProjectRepository? = null
    //private val hashPassword: String = Encoder().encoder("1234")
    private val normalUser: User = User("meli", "meli.jimenez21@gmail.com", "1234",true, "meli")
    override fun run(args: ApplicationArguments) {
        val user: User = normalUser
        val localidadQ = Location("Quilmes", "Buenos Aires", 100, false)
        val localidadB = Location("Bernal", "Buenos Aires", 3200, true)
        val localidadDB = Location("Don Bosco", "Buenos Aires", 800, false)
        val localidadW = Location("Wilde", "Buenos Aires", 1100, false)
        val localidadBO = Location("Bosques", "Buenos Aires", 400000, false)
        val localidadE = Location("Ezpeleta", "Buenos Aires", 120000, true)
        val localidadBE = Location("Berazategui", "Buenos Aires", 50, true)
        val localidadH = Location("Hudson", "Buenos Aires", 8000, false)
        locationRepository!!.save(localidadQ)
        locationRepository.save(localidadB)
        locationRepository.save(localidadDB)
        locationRepository.save(localidadW)
        locationRepository.save(localidadBO)
        locationRepository.save(localidadE)
        locationRepository.save(localidadBE)
        locationRepository.save(localidadH)
        val endDateOne = LocalDate.of(2020, 7, 10)
        val endDateTwo = LocalDate.of(2020, 1, 12)
        val endDateThree = LocalDate.of(2024, 2, 5)
        val endDateFour = LocalDate.of(2032, 2, 28)
        val endDateFive = LocalDate.of(2020, 1, 1)
        val endDateSix = LocalDate.of(2120, 12, 5)
        val endDateSeven = LocalDate.now()
        val endDateEight = LocalDate.now().plusMonths(1)
        val projectBE = Project("Begui", LocalDate.now().plusDays(30), endDateSeven, localidadBE)
        user.collaboratesOnAProject(projectBE, 20000, endDateSeven)
        userRepository.save(user)
        projectRepository!!.save(Project("Nuevo Quilmes", LocalDate.now().plusDays(1), endDateOne, localidadQ))
        projectRepository.save(Project("Bernalesa", LocalDate.now().plusDays(20), endDateTwo, localidadB))
        projectRepository.save(Project("DonBo", LocalDate.now().plusDays(25), endDateThree, localidadDB))
        projectRepository.save(Project("Nuevo Wilde", LocalDate.now().plusDays(12), endDateFive, localidadW))
        projectRepository.save(Project("El Bosque", LocalDate.now().plusDays(8), endDateFour, localidadBO))
        projectRepository.save(Project("La Nueva Ezpeleta", LocalDate.now().plusDays(9), endDateSix, localidadE))
        projectRepository.save(projectBE)
        projectRepository.save(Project("Hudson", LocalDate.now().plusDays(1), endDateEight, localidadH))
    }

    init {
        this.userRepository = userRepository
    }
}