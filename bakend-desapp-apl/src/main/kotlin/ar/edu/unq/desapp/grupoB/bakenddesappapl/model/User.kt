package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.lang.Exception
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity(name = "user")
class User (): Observer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)


    var nameUser: String? = null
    var email: String? = null
    var password: String? = null
    var isAdmin: Boolean? = null
    var nickName: String? = null
    var points: Int = 0
    var cambio: String? = null
    var listOfClosedProjects: ArrayList<Project> = ArrayList()

    @OneToMany(mappedBy = "userD", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listDonor: MutableList<Donor> = mutableListOf()

    constructor(name: String, mail: String, pass: String, admin: Boolean, nick: String) : this(){

        this.nameUser = name
        this.email = mail
        this.password = pass
        this.isAdmin = admin
        this.nickName = nick
    }

    fun collaboratesOnAProject(project: Project, donorUser: Int, date: LocalDate) {

        val donor = Donor(this.nickName!!, donorUser, date)

        project.locationP!!.listDonation.add(donor)
        this.listDonor.add(donor)

        this.scorePoints(donorUser, project, date.month)
        project.donorUsers!!.add(this)

    }

    fun scorePoints(donorUser: Int, project: Project, monthD: Month) {

        if (donorUser > 1000) {

            this.points += donorUser

        }
        if (isProjectWithInhabitants(project)) {

            this.points += (donorUser * 2)

        }
        if (isSecondCollaborationInProject(project, monthD)) {

            this.points += 500
        }


    }

    fun isSecondCollaborationInProject(project: Project, monthD: Month): Boolean {

        //deberia ver que se alla donado a dos proyectos  en el mismo mes
        var res = 0
        for (d: Donor in this.listDonor) {

            if (d.date?.month!! == monthD)

                res += 1

        }

        return (res > 2)

    }

    fun isProjectWithInhabitants(project: Project): Boolean {

        var cantHabitants = project.locationP!!.population

        return (cantHabitants!! > 2000)

    }
    fun theProjectIsComplete(project: Project): Boolean {

        return (project.theMinimunFinancingOfTheWorkWasCollected() && project.itsProjectEndDate())
    }

    fun projectFinished(project: Project) {

        if (isAdmin!! && this.theProjectIsComplete(project)){
                  project.notifyDonorsThatTheProjectHasEnded()
        }
        else {

            throw Exception("Not is Administrator")
          }
    }

    override fun update(p0: Observable?, p1: Any?) {

        this.cambio = p1.toString()
    }


}


