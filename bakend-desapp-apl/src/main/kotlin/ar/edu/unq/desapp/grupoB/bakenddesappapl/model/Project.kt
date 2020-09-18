package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate

class Project {

    var nameProject : String? = null
    var factor : Int = 0
    var porcentageMinClouse : Int? = null
    var dateInit : LocalDate? = null
    var dateEnd : LocalDate? = null
    var location : Location? = null
    var numberOfInhabitants : Int = 0
    var collection :Int =0


    constructor(name: String, porcentage: Int, dateI: LocalDate, dateE: LocalDate, locationP: Location){

        this.nameProject = name
        this.porcentageMinClouse = porcentage
        this.dateInit = dateI
        this.dateEnd = dateE
        this.location = locationP
        this.numberOfInhabitants = locationP.population!!
    }

    fun amountCollected(): Int {
        var localDonations = this.location!!.listDonation
        for (donation: Donor in localDonations) {
            collection += donation.donation!!
        }
        return collection
    }

    fun lastDonation(): Donor {

        return ( this.location!!.lastDonationOfLocation())


    }

    fun theTotalFinancingOfTheWorkWasCollected(): Boolean {
        //SE RECOLECTO EL TOTAL FINANCIAMIENTO DE LA OBRA
        return false
    }

    fun ItsProjectEndDate(): Boolean {
        //RETORNO SI ES LA FECHA FIN DEL POROYECT
        return false
    }
}