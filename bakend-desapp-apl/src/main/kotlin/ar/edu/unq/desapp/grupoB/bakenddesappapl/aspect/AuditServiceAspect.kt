package ar.edu.unq.desapp.grupoB.bakenddesappapl.aspect


import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.*
import java.util.logging.Logger


@Aspect
@Component
class AuditServiceAspect {

    @Aspect
    @Configuration
    @Order(0)
    class ServiceLogger {
        @Pointcut("within(ar.edu.unq.desapp.grupoB.bakenddesappapl.service.*)")
        fun applicationPackagePointcut() {
            // Method is empty as this is just a Pointcut, the implementations are in the
            // advices.
        }

        @Around("applicationPackagePointcut()")
        @Throws(Throwable::class)
        fun logAround(joinPoint: ProceedingJoinPoint): Any {
            val start = System.currentTimeMillis()
            val proceed = joinPoint.proceed()
            val executionTime = System.currentTimeMillis() - start
            logger.info("Class: " + joinPoint.getThis() + ", Method: " + joinPoint.signature.name + ", Args: "
                    + Arrays.toString(joinPoint.args) + ", Time: " + executionTime + "ms")
            return proceed
        }

        companion object {
            private val logger: Logger = Logger.getLogger(ServiceLogger::class.java.toString())
        }
    }
}
