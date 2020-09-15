package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate
import java.time.Month

class User {


    var nameUser : String? = null
    var email : String ? = null
    var password : String ? = null
    var isAdmin : Boolean ? = null
    var nickName : String ? = null
    var points: Int = 0
    var monthDonor : Month? = null

    constructor(name: String, mail: String, pass: String, admin: Boolean, nick: String){

        this.nameUser = name
        this.email = mail
        this.password = pass
        this.isAdmin = admin
        this.nickName = nick
    }

    fun collaboratesOnAProject(project: Project, donorUser: Int, date:Month) {

        val donor = Donor(this.nickName!!,donorUser)

        project.location!!.listDonation.add(donor)

        this.monthDonor = date

        this.scorePoints(donorUser,project,date)

    }

    fun scorePoints(donorUser: Int, project: Project, date:Month) {

        if (donorUser > 1000){

            this.points += donorUser

        }
        if(isProjectWithInhabitants(project)){

            this.points += (donorUser * 2)

        }
        if (isSecondCollaborationInProject(project,date)){

            this.points += 500
        }


    }

    fun isSecondCollaborationInProject(project: Project, monthDonor: Month): Boolean {

        //deberia ver que se alla donado a dos proyectos  en el mismo mes

        return ( this.monthDonor!! == monthDonor)

    }

    fun isProjectWithInhabitants(project: Project): Boolean {

        var cantHabitants = project.location!!.population

        return (cantHabitants!! > 2000)

    }
}