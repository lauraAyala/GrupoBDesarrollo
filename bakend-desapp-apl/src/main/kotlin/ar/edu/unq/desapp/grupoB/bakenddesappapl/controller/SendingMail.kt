package ar.edu.unq.desapp.grupoB.bakenddesappapl.controller

import ar.edu.unq.desapp.grupoB.bakenddesappapl.repository.DonationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller

@Component
@Controller
class SendingMail {

    @Autowired
    lateinit var donationRepository: DonationRepository

    @Scheduled(cron = "0 35 14 * * *")
    fun sendDailyEmail() {

        donationRepository.top10Donations()
    }
}