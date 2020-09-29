package ar.edu.unq.desapp.grupoB.bakenddesappapl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor

interface DonorDao{

    fun createdDonation(donor: Donor)
}