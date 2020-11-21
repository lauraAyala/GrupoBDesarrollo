package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class Donor() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)

    var nickName : String ? = null
    @Column
    var donation: Int ? = null
    @Column
    var date: LocalDate? = null

    @ManyToOne
    var locationD: Location? = null

    @ManyToOne
    var userD: User? = null

    constructor(nick: String, mount: Int, dateL: LocalDate) : this(){
        this.nickName = nick
        this.donation = mount
        this.date = dateL

    }
}