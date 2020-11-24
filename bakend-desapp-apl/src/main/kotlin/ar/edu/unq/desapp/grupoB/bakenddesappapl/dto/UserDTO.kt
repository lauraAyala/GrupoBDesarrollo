package ar.edu.unq.desapp.grupoB.bakenddesappapl.dto

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor

class UserDTO(val nameUser: String, val listDonors: MutableList<Donor>,val points :Int) {
}