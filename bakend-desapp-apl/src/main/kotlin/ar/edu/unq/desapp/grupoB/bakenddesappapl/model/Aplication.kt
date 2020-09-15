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

            if (p.dateEnd!!.month <= LocalDate.now().month){

                projects.add(p)
            }
        }
        return projects
    }
}

