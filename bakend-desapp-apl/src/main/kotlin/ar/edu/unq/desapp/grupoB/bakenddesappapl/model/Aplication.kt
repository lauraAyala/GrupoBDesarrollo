package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate


class Aplication() {


    var listUsers : ArrayList<User> = ArrayList()
    var listProjects : ArrayList<Project> = ArrayList()

    fun userRegister(user : User){

        // se registra un usuario

        this.listUsers.add(user)
    }

   /* fun makeDonation(monto: Int , comentario: String){


    }*/

    fun moneyToProvideInternet(project: Project): Int{

        //Calcula la cantidad de dinero que se necesita para proveer conectividad
        // para una poblacion de un proyecto

        var count = 0

        var location = project.location
        if(project.factor > 0){

            count = location!!.population!! * project.factor

        }
        else{

            count = location!!.population!! * 1000
        }

        return count

    }

    fun addProjects(project: Project){

        //agrega un proyecto a la lista de proyectos

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

    fun top10Donors(): ArrayList<Donor> {

        // devuelve una lista con las 10 donaciones


       var  donors : ArrayList<Donor> = ArrayList()

        for (p: Project in this.listProjects){

            var donor = p.lastDonation()
            donors.add(donor)
        }

        return (orderDonations(donors))
    }

    private fun orderDonations(donors: ArrayList<Donor>): ArrayList<Donor> {

        var donorsRes : ArrayList<Donor> = donors
        var posicion = 0

        for (d:Donor in donorsRes){

            var donor = donors.get(posicion + 1)

            if (d.date!! >  donor.date) {

                donorsRes.add(posicion, d)
                donorsRes.add(posicion + 1, donor)
                posicion += 1

            }

            posicion += 1
        }

        return this.only10Donatios(donorsRes)

    }

    private fun only10Donatios(donors:ArrayList<Donor>): ArrayList<Donor> {


        var donorsRes : ArrayList<Donor> = ArrayList()
        var longitud = donors.size
        var cont = 10
        var posicion = 0
        var donor = donors.get(posicion)

        while(cont > 0 && longitud != posicion){
            donorsRes.add(donor)
            cont -= 1
            posicion += 1

        }

        return donorsRes
    }

}

