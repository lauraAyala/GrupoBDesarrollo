package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Project {

    var nameProject : String? = null
    var factor : Int? = null
    var porcentageMinClouse : Int? = null
    var dateInit : String? = null
    var dateEnd : String? = null

    constructor(name:String, factorP:Int, porcentage:Int, dateI:String, dateF:String){

        this.nameProject = name
        this.factor = factorP
        this.porcentageMinClouse = porcentage
        this.dateInit = dateI
        this.dateEnd = dateF
    }
}