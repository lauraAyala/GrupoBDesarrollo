package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Location {

    var name: String? = null
    var province: String? = null
    var population : Int? = null
    var stateConective : Boolean? = null
    var listDonation : String? = null

    constructor(nameLocation:String, provinceL:String, populationL: Int, conective:Boolean){

        this.name = nameLocation
        this.province = provinceL
        this.population = populationL
        this.stateConective = conective
    }

}

