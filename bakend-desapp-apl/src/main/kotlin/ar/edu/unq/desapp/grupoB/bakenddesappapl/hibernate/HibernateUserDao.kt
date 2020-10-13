package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.UserDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner


class HibernateUserDao : HibernateDAO<User>(User::class.java),UserDao {
    override fun createUser(user: User): Int {

        this.save(user)

        return (this.recover(user.id!!.toLong()).id!!.toInt())
    }

    override fun updateUser(user: User) {
        val session = TransactionRunner.currentSession

        session.saveOrUpdate(user)
    }

    override fun recoverUser(id:Long): User {

        return (this.recover(id))
    }

    override fun allDonation(user: User): MutableList<Donor> {
        val session = TransactionRunner.currentSession

        val hql = """
                     select d from  user l join user.listDonor d where d.userD_id = :anId
                      
                    """

        val query = session.createQuery(hql, Donor::class.java)

        query.setParameter("anId",user.id)

        return query.resultList
    }

  /*  override fun collaboratesOnAProject(user: User,project: Project, donorUser: Int, date: LocalDate){

        val session = TransactionRunner.currentSession

        user.collaboratesOnAProject(project,donorUser,date)
        session.saveOrUpdate(user)

        //donor.locationD= location
        //        session.saveOrUpdate(donor)

    */
}
