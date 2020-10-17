package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import javax.persistence.*

@Entity(name = "location")
@Table
class Location() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    @Column(nullable = false, length = 500)
    var name: String? = null
    var province: String? = null
    var population : Int? = null
    var stateConective : Boolean? = null

    @OneToMany(mappedBy = "locationD", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listDonation : MutableList<Donor> = mutableListOf()
    var collection : Int = 0

    @OneToMany( mappedBy = "locationP",cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var projects : MutableList<Project> = mutableListOf()

    constructor(nameLocation:String, provinceL:String, populationL: Int, conective:Boolean): this(){

        this.name = nameLocation
        this.province = provinceL
        this.population = populationL
        this.stateConective = conective
    }

    fun donorRegister (donor: Donor){
        this.listDonation.add(donor)
    }

    fun lastDonationOfLocation(): Donor {

        var longitud = (this.listDonation.size) -1
        return ( this.listDonation.get(longitud))

    }
}

