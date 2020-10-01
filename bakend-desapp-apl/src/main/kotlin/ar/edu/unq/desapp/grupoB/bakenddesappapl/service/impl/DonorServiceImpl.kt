package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DataDAO
import ar.edu.unq.desapp.grupoB.bakenddesappapl.DonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.DonorService
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner.runTrx
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionType

class DonorServiceImpl(private val donorDAO: DonorDao,
                       private val dataDAO: DataDAO) : DonorService {

    override fun createdDonation(donor: Donor) {

        return runTrx({ donorDAO.createdDonation(donor);TransactionType.HIBERNATE })
    }

    override fun recoverDonor(id: Long): Donor {
        return runTrx({ donorDAO.recoverDonor(id)})}
}