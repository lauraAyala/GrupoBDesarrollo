package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.mail.internet.MimeMessage

/*
@Transactional
@Service
class EmailService {
    @Autowired
    private val javaMailSender: JavaMailSender? = null

    @Async
    fun notifyNews(donors: List<Donor>, project: Project) {
        for (donor in donors) {
            sendNews(donor, project)
        }
    }

    private fun sendNews(donor: Donor, project: Project) {
        val mailMessage: MimeMessage = javaMailSender!!.createMimeMessage()
        val helper: MimeMessageHelper
        try {
            helper = MimeMessageHelper(mailMessage, true)
            helper.setTo(donor.getMail())
            helper.setSubject("Notify News")
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div> Dear " + donor.getName() + "</div>"
                            + "<div>We inform you that project: </div>"
                            + "<div><strong>" + project.getName() + "</strong></div>"
                            + "<div> will be started. <div/>"
                            + "</div>"
                            + "<div>Thanks to your donation.</div>"
                            + "<div>The Team Admin.</div>"
                            + "</body>"
                            + "</html>", true)
            javaMailSender.send(mailMessage)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }

    @Async
    fun sendTop10Projects(projects: List<Project>, donors: List<Donor>) {
        val projectNames = findProjectNames(projects)
        for (donor in donors) {
            senTop10ADonorProject(donor, projectNames)
        }
    }

    private fun findProjectNames(projects: List<Project>): String {
        var names = ""
        for (project in projects) {
            names += project.getName().toString() + ", "
        }
        return names.substring(0, names.length - 2)
    }

    fun senTop10ADonorProject(donor: Donor, projectNames: String) {
        val mailMessage: MimeMessage = javaMailSender.createMimeMessage()
        val helper: MimeMessageHelper
        try {
            helper = MimeMessageHelper(mailMessage, true)
            helper.setFrom("crowdfundinggrupoi@gmail.com")
            helper.setTo(donor.getMail())
            helper.setSubject("Tops 10 Project")
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div> Dear " + donor.getName() + "</div>"
                            + "<div>We inform then top 10 of donated projects: </div>"
                            + "<div><strong>" + projectNames + "</strong></div>"
                            + "</div>"
                            + "<div>The Team Admin.</div>"
                            + "</body>"
                            + "</html>", true)
            javaMailSender.send(mailMessage)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }

    @Async
    fun sendTop10Locations(locations: List<Location>, donors: List<Donor>) {
        val locationsNames = findLocationNames(locations)
        for (donor in donors) {
            senTop10LocationsADonor(donor, locationsNames)
        }
    }

    private fun senTop10LocationsADonor(donor: Donor, locationsNames: String) {
        val mailMessage: MimeMessage = javaMailSender.createMimeMessage()
        val helper: MimeMessageHelper
        try {
            helper = MimeMessageHelper(mailMessage, true)
            helper.setTo(donor.getMail())
            helper.setSubject("Tops 10 Localidades")
            helper.setText(
                    "<html>"
                            + "<body>"
                            + "<div>"
                            + "<div> Dear " + donor.getName() + "</div>"
                            + "<div>We inform then top 10 of minus donated localities: </div>"
                            + "<div><strong>" + locationsNames + "</strong></div>"
                            + "</div>"
                            + "<div>The Team Admin.</div>"
                            + "</body>"
                            + "</html>", true)
            javaMailSender.send(mailMessage)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }

    private fun findLocationNames(locations: List<Location>): String {
        var names = ""
        for (location in locations) {
            names += location.getName().toString() + ", "
        }
        return names.substring(0, names.length - 2)
    }
}
*/
 