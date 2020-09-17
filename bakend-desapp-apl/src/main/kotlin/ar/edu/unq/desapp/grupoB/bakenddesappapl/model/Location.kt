package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Location {

    var name: String? = null
    var province: String? = null
    var population : Int? = null
    var stateConective : Boolean? = null
    var listDonation : ArrayList<Donor> = ArrayList()
    var collection : Int = 0

    constructor(nameLocation:String, provinceL:String, populationL: Int, conective:Boolean){

        this.name = nameLocation
        this.province = provinceL
        this.population = populationL
        this.stateConective = conective
    }

    fun donorRegister (donor: Donor){
        this.listDonation.add(donor)
    }

    fun lastDonationOfLocation(): Donor {

        var longitud = this.listDonation.size
        return ( this.listDonation.get(longitud))

    }
}

