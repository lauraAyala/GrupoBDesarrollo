package ar.edu.unq.desapp.grupoB.bakenddesappapl.service

/*import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.stereotype.Service*/
import java.util.*
import java.util.stream.Collectors

/*
@Service
class JWTTokenService {


      fun getJWTToken(name: String?): String {
           val secretKey = "mySecretKey"
           val grantedAuthorities: List<GrantedAuthority> = AuthorityUtils
                   .commaSeparatedStringToAuthorityList("isAdmin")
           val token = Jwts
                   .builder()
                   .setSubject(name)
                   .claim("authorities",
                           grantedAuthorities.stream()
                                   .map<Any>(GrantedAuthority::getAuthority)
                                   .collect(Collectors.toList()))
                   .setIssuedAt(Date(System.currentTimeMillis()))
                   .setExpiration(Date(System.currentTimeMillis() + 86400))
                   .signWith(SignatureAlgorithm.RS256,
                           secretKey.toByteArray()).compact()
           return "Bearer $token"
       }
}*/

