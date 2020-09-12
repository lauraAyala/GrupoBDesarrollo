package kotlin.ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Donor {
    var nickName : String ? = null
    var donation: String ? = null

    constructor(nick :String, donation :String){
        this.nickName = nick
        this.donation = donation

    }
}