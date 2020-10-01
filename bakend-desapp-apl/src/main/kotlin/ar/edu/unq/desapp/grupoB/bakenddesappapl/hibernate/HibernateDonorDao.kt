package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.DonorDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Donor
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.User

open class HibernateDonorDao : HibernateDAO<Donor>(Donor::class.java),DonorDao{
    override fun createdDonation(donor: Donor) {

        this.guardar(donor)

    }

    override fun recoverDonor(id: Long): Donor {

        return (this.recuperar(id.toLong()))
    }
}

/*open class HibernatePatogenoDAO : HibernateDAO<Patogeno>(Patogeno::class.java), PatogenoDAO {

    override fun crear(patogeno: Patogeno): Int {
        this.guardar(patogeno)
        return (this.recuperar(patogeno.id).id!!.toInt())
    }*/