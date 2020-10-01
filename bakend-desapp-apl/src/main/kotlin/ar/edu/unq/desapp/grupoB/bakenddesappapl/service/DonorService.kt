package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor

interface DonorService {

    fun createdDonation(donor: Donor)
    fun recoverDonor(id: Long): Donor?

}