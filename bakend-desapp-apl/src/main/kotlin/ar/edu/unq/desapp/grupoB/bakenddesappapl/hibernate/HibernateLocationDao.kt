package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.LocationDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner

open class HibernateLocationDao :HibernateDAO<Location>(Location::class.java), LocationDao {

    override fun createdLocation(location: Location) : Location{

        this.save(location)

        val session = TransactionRunner.currentSession

        val hql = """
                     select l from  location l where l.name = :anName
                      
                    """

        val query = session.createQuery(hql, Location::class.java)

        query.setParameter("anName",location.name)

        return query.singleResult

    }

    override fun updateLocation(location: Location) {

        val session = TransactionRunner.currentSession

        session.saveOrUpdate(location)
    }

    override fun recoverLocation(id: Long): Location {

        return (this.recover(id))

    }

    override fun registerDonor(location: Location,donor: Donor) {


        val session = TransactionRunner.currentSession



        location.donorRegister(donor)
        session.saveOrUpdate(location)
        donor.locationD= location
        session.saveOrUpdate(donor)

    }

    override fun allDonations(location: Location): MutableList<Donor> {

        val session = TransactionRunner.currentSession

        val hql = """
                     select d from  location l join location.listDonation d where d.locatonD_id = :anId
                      
                    """

        val query = session.createQuery(hql, Donor::class.java)

        query.setParameter("anId",location.id)

        return query.resultList
    }

    override fun allLocations(): MutableList<Location> {

        val session = TransactionRunner.currentSession

        val hql= " from location"

        val query = session.createQuery(hql,Location::class.java)

        return query.resultList
    }
}