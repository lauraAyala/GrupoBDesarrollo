package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

interface DonorDao{

    fun createdDonation(donor: Donor)
    fun recoverDonor(id:Long) : Donor
}