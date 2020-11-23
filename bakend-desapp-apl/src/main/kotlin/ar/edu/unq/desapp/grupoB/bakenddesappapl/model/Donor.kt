package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
class Donor() : Serializable {

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

    constructor(user:User, mount: Int, dateL: LocalDate) : this(){
        this.nickName = user.nickName
        this.donation = mount
        this.date = dateL
        this.userD = user

    }
}