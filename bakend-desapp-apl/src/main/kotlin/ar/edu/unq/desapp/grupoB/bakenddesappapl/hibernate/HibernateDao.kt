package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner

open class HibernateDAO<T>(private val entityType: Class<T>) {


    fun save(item: T) {
        val session = TransactionRunner.currentSession
        session.save(item)
    }

    fun recover(id: Long?): T {
        val session = TransactionRunner.currentSession
        return session.get(entityType, id)
    }
}