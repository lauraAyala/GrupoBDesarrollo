package ar.edu.unq.desapp.grupoB.bakenddesappapl.repository

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
interface UserRepository:JpaRepository<User, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM user_of_app WHERE nameUser = :name", nativeQuery = true)

    fun deleteByName(@Param("name") name: String?): Int?


}