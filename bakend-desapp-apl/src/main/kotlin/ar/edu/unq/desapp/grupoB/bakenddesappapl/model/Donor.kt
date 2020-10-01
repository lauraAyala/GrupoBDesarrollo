package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate
import javax.persistence.*

@Entity(name = "donor")
@Table(name = "donor")
class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    var nickName : String ? = null
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    var donation: Int ? = null
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
    var date: LocalDate? = null



    constructor(nick: String, donation: Int, dateL: LocalDate){
        this.nickName = nick
        this.donation = donation
        this.date = dateL

    }
}