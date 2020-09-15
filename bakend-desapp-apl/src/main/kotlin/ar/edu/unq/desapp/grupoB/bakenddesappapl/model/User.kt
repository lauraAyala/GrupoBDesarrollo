package ar.edu.unq.desapp.grupoB.bakenddesappapl.model

class User {

    var nameUser : String? = null
    var email : String ? = null
    var password : String ? = null
    var isAdmin : Boolean ? = null
    var nickName : String ? = null
    var listPoints: ArrayList<Int> = ArrayList()

    constructor(name: String, mail: String, pass: String, admin: Boolean, nick: String){

        this.nameUser = name
        this.email = mail
        this.password = pass
        this.isAdmin = admin
        this.nickName = nick
    }

}