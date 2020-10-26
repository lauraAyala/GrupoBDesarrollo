package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import javax.persistence.*

@Entity
@Table
class Location() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null


    @Column(nullable = false, length = 500)
    var name: String? = null
    @Column
    var province: String? = null
    @Column
    var population : Int? = null
    @Column
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

