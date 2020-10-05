package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor

open class HibernateDonorDao : HibernateDAO<Donor>(Donor::class.java),DonorDao{

    override fun createdDonation(donor: Donor){

        this.save(donor)
    }

    override fun recoverDonor(id: Long): Donor {

        return (this.recover(id))
    }
}
