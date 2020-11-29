package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DonationService {

    @Autowired
    lateinit var donationRepository: DonationRepository

   /*@Throws(Exception::class)
    fun login(mail: String?, password: String?) {
        return try {
            val donorLogin: Donor = donationRepository.findByMail(mail)
            if (!donorLogin.getPassword().equals(password)) {
                throw ErrorLogin()
            }
            val token: String = jWTTokenService.getJWTToken(donorLogin.getName())
            donorLogin.setToken(token)
            donorLogin
        } catch (e: Exception) {
            throw ErrorLogin()
        }
    }*/


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