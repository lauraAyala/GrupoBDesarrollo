package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import kotlin.jvm.Transient

@Entity
class Donor() : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Nickname  is required")
    var nickName : String ? = null

    @Column
    @NotNull(message = "Donation is required")
    var donation: Int ? = null

    @Column
    @NotNull(message = "Date is required")
    var date: LocalDate? = null

    @Transient
     @OneToOne
    var userD: User? = null

    constructor(user:User, mount: Int, dateL: LocalDate) : this(){
        this.nickName = user.nickName
        this.donation = mount
        this.date = dateL
        this.userD = user

    }
}