package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate
import javax.persistence.*

@Entity (name = "donor")
class Donor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)

    var nickName : String ? = null
    var donation: Int ? = null
    var date: LocalDate? = null

    @ManyToOne
    var locationD: Location? = null

    @ManyToOne
    var userD: User? = null

    constructor(nick: String, donation: Int, dateL: LocalDate) : this(){
        this.nickName = nick
        this.donation = donation
        this.date = dateL

    }
}