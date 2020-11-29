package ar.edu.unq.desapp.grupoB.bakenddesappapl

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication

@EnableAutoConfiguration
@SpringBootApplication()
@EnableScheduling
class BakendDesappAplApplication

fun main(args: Array<String>) {
	runApplication<BakendDesappAplApplication>(*args)
}
