package ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner

import org.hibernate.Session


interface Transaction {
    fun start()
    fun commit()
    fun rollback()
}

class HibernateTransaction: Transaction {
    private var transaction: org.hibernate.Transaction? = null

    companion object {
        private var session: Session? = null
        val currentSession: Session
            get() {
                if (session == null) {
                    throw RuntimeException("No hay ninguna session en el contexto")
                }
                return session!!
            }
    }

    override fun start() {
        session = HibernateSessionFactoryProvider.instance.createSession()
        transaction = session?.beginTransaction()
    }

    override fun commit() {
        transaction?.commit()
        session?.close()
    }

    override fun rollback() {
        transaction?.rollback()
        session?.close()
    }
}


enum class TransactionType {

    HIBERNATE {
        fun getTransaction(): Transaction {
            return HibernateTransaction()
        }

    }

}

