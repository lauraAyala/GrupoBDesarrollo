package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import javax.persistence.*

@Entity(name = "location")
class Location() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


    @Column(nullable = false, length = 500)
    var name: String? = null
    var province: String? = null
    var population : Int? = null
    var stateConective : Boolean? = null

    @OneToMany(mappedBy = "location", cascade = [javax.persistence.CascadeType.ALL], fetch = FetchType.EAGER)
    var listDonation : ArrayList<Donor> = ArrayList()
    var collection : Int = 0

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

