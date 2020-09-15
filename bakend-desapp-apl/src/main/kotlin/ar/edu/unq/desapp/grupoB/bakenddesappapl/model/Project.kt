package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate

class Project {

    var nameProject : String? = null
    var factor : Int = 0
    var porcentageMinClouse : Int? = null
    var dateInit : LocalDate? = null
    var dateEnd : LocalDate? = null
    var location : Location? = null
    var users :  ArrayList<User> = ArrayList()


    constructor(name:String, porcentage:Int, dateI:LocalDate, locationP: Location){

        this.nameProject = name
        this.porcentageMinClouse = porcentage
        this.dateInit = dateI
        this.location = locationP
    }

}