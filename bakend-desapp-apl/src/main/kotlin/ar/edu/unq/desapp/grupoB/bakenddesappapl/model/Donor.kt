package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

import java.time.LocalDate

class Donor {
    var nickName : String ? = null
    var donation: Int ? = null
    var date: LocalDate? = null

    constructor(nick: String, donation: Int, dateL: LocalDate){
        this.nickName = nick
        this.donation = donation
        this.date = dateL

    }
}