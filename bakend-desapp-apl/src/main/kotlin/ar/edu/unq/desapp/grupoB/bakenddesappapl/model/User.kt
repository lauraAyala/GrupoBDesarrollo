package ar.edu.unq.desapp.grupoB.bakenddesappapl.model


import java.lang.Exception
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.persistence.*
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import kotlin.collections.ArrayList
import kotlin.jvm.Transient

@Entity
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)

class User (){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq")
    var id: Long? = null

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Name user is required")
    var nameUser: String? = null

    @Column
    @NotBlank(message = "Email is required")
    var email: String? = null

    @Column
    @NotBlank(message = "Password is required")
    var password: String? = null

    @Column
    var isAdmin: Boolean? = null

    @Column
    @NotBlank(message = "Nickname  is required")
    var nickName: String? = null

    @Column
    @NotNull(message = "Points is required")
    var points: Int = 0

    @Transient
    var cambio: String? = null
    var listOfClosedProjects: ArrayList<Project> = ArrayList()

   // @OneToMany(mappedBy = "userD", cascade = [CascadeType.ALL])

   @Transient
    @OneToMany
    var listDonor: MutableList<Donor> = mutableListOf()

    @Transient
    var tokend:String? = null

    constructor(name: String, mail: String, pass: String, admin: Boolean, nick: String) : this(){

        this.nameUser = name
        this.email = mail
        this.password = pass
        this.isAdmin = admin
        this.nickName = nick
    }

    fun collaboratesOnAProject(project: Project, donorUser: Int, date: LocalDate) : Donor {

        val donor = Donor(this, donorUser, date)

       project.locationP!!.listDonation.add(donor)
        var mount = project.amountCollected()
        project.collection = mount
        this.listDonor.add(donor)

        this.scorePoints(donorUser, project, date.month)
        project.donorUsers.add(this)

        return donor

    }

    fun scorePoints(donorUser: Int, project: Project, monthD: Month) {

        if (donorUser > 1000) {

            this.points += donorUser

        }
        if (isProjectWithInhabitants(project)) {

            this.points += (donorUser * 2)

        }
        if (isSecondCollaborationInProject(monthD)) {

            this.points += 500
        }


    }

    fun isSecondCollaborationInProject(monthD: Month): Boolean {

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

        if (this.isAdmin!! && this.theProjectIsComplete(project)){
                  project.notifyDonorsThatTheProjectHasEnded()
        }
        else {

            throw Exception("Not is Administrator")
          }
    }

   /*override fun update(p0: Observable?, p1: Any?) {

        this.cambio = p1.toString()
    }*/


}


