package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Proyecto {

    var nameProyect : String? = null
    var factor : Int? = null
    var porcentageMinClouse : Int? = null
    var dateInit : String? = null
    var dateEnd : String? = null

    constructor(name:String, factorP:Int, porcentage:Int, dateI:String, dateF:String){

        this.nameProyect = name
        this.factor = factorP
        this.porcentageMinClouse = porcentage
        this.dateInit = dateI
        this.dateEnd = dateF
    }
}