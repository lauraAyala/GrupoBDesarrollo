package ar.edu.unq.desapp.grupoB.bakenddesappapl.model


import java.time.LocalDate
import javax.persistence.*

@Entity(name = "proyect")

class Project() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)

    var nameProject : String? = null
    var factor : Int = 0
    var porcentageMinClouse : Int = 50
    var dateInit : LocalDate? = null
    var dateEnd : LocalDate? = null
    var location : Location? = null
    var numberOfInhabitants : Int = 0
    var collection :Int =0
    var donorUsers:ArrayList<User> = ArrayList()


    constructor(name: String,dateI: LocalDate, dateE: LocalDate, locationP: Location): this (){

        this.nameProject = name
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

        //devuelve la ultima donation

        return ( this.location!!.lastDonationOfLocation())


    }

    fun theMinimunFinancingOfTheWorkWasCollected(): Boolean {
        //SE RECOLECTO EL MINIIMO DEL FINANCIAMIENTO DE LA OBRA
        return this.amountCollected() >= this.calculateMinimumClosingPorcentage()
    }

    fun itsProjectEndDate(): Boolean {
        //RETORNO SI ES LA FECHA FIN DEL POROYECT
        var currenteDate =LocalDate.now()
        return currenteDate == dateEnd
    }

    fun donationsProject(): ArrayList<Donor> {

        //devuelve la lista de donaciones del proyecto

        return (this.location!!.listDonation)
    }

    fun moneyneeded(): Int {

        var count = 0

        var location = this.location
        if(this.factor > 0){

            count = location!!.population!! * this.factor

        }
        else{

            count = location!!.population!! * 1000
        }

        return count

    }

    fun calculateMinimumClosingPorcentage ():Int{
      return  this.moneyneeded() * this.porcentageMinClouse / 100
    }

    fun notifyDonorsThatTheProjectHasEnded() {
        for (user: User in this.donorUsers){
            user.listOfClosedProjects.add(this)

        }
    }
}