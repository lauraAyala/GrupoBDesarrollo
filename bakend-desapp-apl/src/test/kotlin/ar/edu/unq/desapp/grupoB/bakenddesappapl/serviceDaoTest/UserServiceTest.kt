package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest

import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate.HibernateUserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.DataServiceImpl
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.impl.UserServiceImpl
import org.junit.Assert
import org.junit.jupiter.api.Test

class UserServiceTest {
     val dao: UserDao = HibernateUserDao()
     var service = UserServiceImpl(dao, DataServiceImpl())

    @Test
    fun createdAnUser(){

        var user = User("Melina","meli@gmail","1234",false,"meli")
        var id = service.createUser(user)
        var userRecover = service.recover(1)

      //  Assert.assertEquals("Melina", service.recover(user.id!!).nameUser)

    }
}