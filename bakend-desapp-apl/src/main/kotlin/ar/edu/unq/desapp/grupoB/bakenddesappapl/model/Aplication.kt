package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList


open class Aplication() : Observable(){


    var listUsers : ArrayList<User> = ArrayList()
    var listProjects : ArrayList<Project> = ArrayList()
    var date : LocalDate? = null

    fun userRegister(user : User){

        this.listUsers.add(user)
        this.addObserver(user)
    }

    fun moneyToProvideInternet(project: Project): Int{

        return project.moneyneeded()
    }

    fun addProjects(project: Project){

        this.listProjects.add(project)
    }

    fun listOfOpenProjects(): ArrayList<Project> {

        // devuelve una lista con los proyectos abiertos

        var projects : ArrayList<Project> = ArrayList()

        for(p: Project in this.listProjects){

            if (isOfOpenProject(p)){

                projects.add(p)

            }
        }
        return projects
    }

    private fun isOfOpenProject(project: Project): Boolean {

        // verifica si un proyecto esta abierto

        return ( project.dateEnd!! < LocalDate.now())
    }

    fun listOfProjectsNearingCompletion(): ArrayList<Project> {
        // devuelve una lista con los proyectos proximos a cerrarse

        var projects : ArrayList<Project> = ArrayList()

        for(p: Project in this.listProjects){

            if (p.dateEnd!!.month == LocalDate.now().month){

                projects.add(p)
            }
        }
        return projects
    }

    fun top10Locations(): ArrayList<Location> {

        // devuelve una lista con las 10 donaciones


        var  locations : ArrayList<Location> = ArrayList()

        for (p: Project in this.listProjects){

            var location = p.locationP
            locations.add(location!!)
        }
        locations.sortBy { it.lastDonationOfLocation().date}
        locations.reversed()

        return ( only10Locations(locations))
    }


    private fun only10Locations(locations:ArrayList<Location>): ArrayList<Location> {


        var locationsRes : ArrayList<Location> = ArrayList()
        var longitud = (locations.size) - 1
        var cont = 10
        var posicion = 0
        var location = locations.get(posicion)

        while(cont > 0 && longitud != posicion){
            locationsRes.add(location)
            cont -= 1
            posicion += 1

        }

        return locationsRes
    }

    fun totalCollected(project: Project):Int {
        return project.amountCollected()
    }

    fun top10Donations(): ArrayList<Donor> {

        var donations : ArrayList<Donor> = ArrayList()

        for (p: Project in this.listProjects){

            donations.addAll(p.donationsProject())

        }

        donations.sortBy { it.donation}
        donations.reversed()

        return (only10Donations(donations))

    }

    private fun only10Donations(donations: ArrayList<Donor>): ArrayList<Donor> {

        var donationsRes : ArrayList<Donor> = ArrayList()
        var longitud = (donations.size) - 1
        var cont = 10
        var posicion = 0
        var donation = donations.get(posicion)

        while(cont > 0 && longitud != posicion){
            donationsRes.add(donation)
            cont -= 1
            posicion += 1

        }

       return donationsRes
    }

    fun cambiarFecha(date: LocalDate){

        this.date = date
        this.setChanged()
        this.notifyObservers("the top 10 are already available")

    }

}

