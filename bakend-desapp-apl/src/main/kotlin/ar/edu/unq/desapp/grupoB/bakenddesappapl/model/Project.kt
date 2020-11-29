package ar.edu.unq.desapp.grupoB.bakenddesappapl.model


import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import kotlin.jvm.Transient

@Entity
class Project() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Project Name is required")
    var nameProject : String? = null

    @Column(nullable = false, length = 500)
    @NotNull(message = "Factor is required")
    var factor : Int = 0

    @Column(nullable = false, length = 500)
    @NotNull(message = "Porcentage Min is required")
    var porcentageMinClouse : Int = 50

    @Column(nullable = false, length = 500)
    @NotNull(message = "Date Init is required")
    var dateInit : LocalDate? = null

    @Column(nullable = false, length = 500)
    @NotNull(message = "Date End is required")
    var dateEnd : LocalDate? = null

    @Column(nullable = false, length = 500)
    @NotNull(message = "Number Of Inhabitants is required")
    var numberOfInhabitants : Int = 0

    @Column(nullable = false, length = 500)
    @NotNull(message = "Collection is required")
    var collection :Int =0

    @Column(nullable = false, length = 500)
    var donorUsers:ArrayList<User> = ArrayList()

    @Transient
    var locationP : Location? = null


    constructor(name: String,dateI: LocalDate, dateE: LocalDate, location: Location): this (){

        this.nameProject = name
        this.dateInit = dateI
        this.dateEnd = dateE
        this.locationP = location
        this.numberOfInhabitants = location.population!!
    }


    fun amountCollected(): Int {
        var localDonations = this.locationP!!.listDonation
        for (donation: Donor in localDonations) {
            collection += donation.donation!!
        }
        return collection
    }

    fun lastDonation(): Donor {

        //devuelve la ultima donation

        return ( this.locationP!!.lastDonationOfLocation())


    }

    fun theMinimunFinancingOfTheWorkWasCollected(): Boolean {
        //SE RECOLECTO EL MINIIMO DEL FINANCIAMIENTO DE LA OBRA
        return this.amountCollected() >= this.calculateMinimumClosingPorcentage()
    }

    fun itsProjectEndDate(): Boolean {
        //RETORNO SI ES LA FECHA FIN DEL POROYECT
        var currenteDate = LocalDate.now()
        return currenteDate >= dateEnd
    }

    fun donationsProject(): MutableList<Donor> {

        //devuelve la lista de donaciones del proyecto

        return (this.locationP!!.listDonation)
    }

    fun moneyneeded(): Int {

        var count = 0

        var location = this.locationP
        if(this.factor > 0){

            count += location!!.population!! * this.factor

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

    fun isCloseToClosing(): Boolean {

        val date = LocalDate.now()

        return this.dateEnd?.month == date.month && this.dateEnd?.year == date.year

    }
}
