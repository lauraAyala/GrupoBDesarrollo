package ar.edu.unq.desapp.grupoB.bakenddesappapl.serviceDaoTest


class UserServiceTest {
   /*  val dao= HibernateUserDao()
     var daoLocation = HibernateLocationDao()
     var service = UserServiceImpl(dao, DataServiceImpl())
     var serviceLocation = LocationServiceImpl(daoLocation,DataServiceImpl())

    @Test
    fun createdAnUser(){

        var user = User("Melina","meli@gmail","1234",false,"meli")
        service.createUser(user)

       Assert.assertEquals("Melina", service.recoverUser(user.id!!).nameUser)
        Assert.assertEquals("meli@gmail", service.recoverUser(user.id!!).email)
        Assert.assertEquals("1234", service.recoverUser(user.id!!).password)
        Assert.assertEquals("meli", service.recoverUser(user.id!!).nickName)
        Assert.assertEquals(false, service.recoverUser(user.id!!).isAdmin)

    }

    /*@Test
    fun AuserCollaboratesOnAProject(){

        var user    = User("Lara","laraA@gmail.com","lara", false,"ara")
        var bernal  = Location("Bernal", "Buenos Aires", 1000, false)
        var fecha   = LocalDate.of(2020,5,12)
        var project = Project("ProjectInitial", fecha!!, LocalDate.of(2020,7,8), bernal!!)

        user!!.collaboratesOnAProject(project!!,1200, LocalDate.of(2020,5,12))


        //Assert.assertEquals(1, service.recoverUser()
    //        Assert.assertEquals(user!!.points,1200)
    //
    //    }*/

    */
}