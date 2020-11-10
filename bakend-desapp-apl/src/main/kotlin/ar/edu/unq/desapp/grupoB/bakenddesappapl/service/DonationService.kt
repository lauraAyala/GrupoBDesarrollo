package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DonationService {

    @Autowired
    lateinit var donationRepository: DonationRepository

    fun createdDonation(donor: Donor): Donor {

        return donationRepository.save(donor)
    }

    fun recoverDonation(id: Long): Donor{

        return donationRepository.getOne(id)
    }

    fun allDonations(): MutableList<Donor> {

        return donationRepository.findAll()

    }

    fun top10Donations(): MutableList<Donor> {

        return donationRepository.top10Donations()
    }
}