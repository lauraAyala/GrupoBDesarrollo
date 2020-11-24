package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Location() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)
    @NotBlank(message = " Name is required")
    var name: String? = null

    @Column
    @NotBlank(message = "Province is required")
    var province: String? = null

    @Column
    @NotNull(message = "Population is required")
    var population : Int? = null

    @Column
    var stateConective : Boolean? = null

    @OneToMany(mappedBy = "locationD", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
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

