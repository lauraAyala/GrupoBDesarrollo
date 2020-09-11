package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Location {

    var name: String? = null
    var province: String? = null
    var population : Int? = null
    var stateConective : String? = null
    var listDonation : String? = null

    constructor(nameLocation:String, provinceL:String, populationL: Int, conective:String){

        this.name = nameLocation
        this.province = provinceL
        this.population = populationL
        this.stateConective = conective
    }

}