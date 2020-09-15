package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class Donor {
    var nickName : String ? = null
    var donation: Int ? = null

    constructor(nick :String, donation :Int){
        this.nickName = nick
        this.donation = donation

    }
}