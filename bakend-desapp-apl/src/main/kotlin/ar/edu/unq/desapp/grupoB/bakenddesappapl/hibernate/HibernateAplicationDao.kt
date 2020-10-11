package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.*
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.AplicationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner

class HibernateAplicationDao : HibernateDAO<Aplication>(Aplication::class.java), AplicationDao  {


    override fun allUsers(): MutableList<User> {

        val session = TransactionRunner.currentSession

        val hql= """ Select * from user"""

        val query = session.createQuery(hql,User::class.java)

        return query.resultList


    }

    override fun allProjects(): MutableList<Project> {

        val session = TransactionRunner.currentSession

        val hql= """ Select * from project"""

        val query = session.createQuery(hql,Project::class.java)

        return query.resultList
    }

    override fun top10Locations(): MutableList<Location> {
        TODO("Not yet implemented")
    }

    override fun top10Donations(): MutableList<Donor> {
        TODO("Not yet implemented")
    }

    override fun allLocations(): MutableList<Location> {

        val session = TransactionRunner.currentSession

        val hql= """ Select * from location"""

        val query = session.createQuery(hql,Location::class.java)

        return query.resultList
    }


}