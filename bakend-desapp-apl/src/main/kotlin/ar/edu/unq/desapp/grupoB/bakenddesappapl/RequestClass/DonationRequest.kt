package ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import java.time.LocalDate

class DonationRequest(val user: Int,val project: Int,val donorUser: Int,val date: LocalDate) {
}