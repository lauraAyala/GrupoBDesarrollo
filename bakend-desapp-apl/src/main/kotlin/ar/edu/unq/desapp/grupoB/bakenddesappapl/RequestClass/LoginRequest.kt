package ar.edu.unq.desapp.grupoB.bakenddesappapl.RequestClass

import sun.security.util.Password
import javax.validation.constraints.Email

class LoginRequest(val email: String, val password: String ) {
}