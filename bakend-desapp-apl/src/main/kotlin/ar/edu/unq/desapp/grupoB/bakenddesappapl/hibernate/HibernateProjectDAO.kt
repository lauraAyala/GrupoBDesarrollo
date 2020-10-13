package ar.edu.unq.desapp.grupoB.bakenddesappapl.hibernate

import ar.edu.unq.desapp.grupoB.bakenddesappapl.ProjectDao
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project
import ar.edu.unq.desapp.grupoB.bakenddesappapl.service.runner.TransactionRunner

class HibernateProjectDAO : HibernateDAO<Project>(Project::class.java),ProjectDao {
    override fun createdProject(project: Project): Int {

        this.save(project)

        return (this.recover(project.id!!.toLong()).id!!.toInt())
    }

    override fun recoverProject(id: Long): Project {

        return (this.recover(id))
    }

    override fun updateProject(project: Project) {

        val session = TransactionRunner.currentSession

       session.saveOrUpdate(project)

    }

    override fun allProjects(): MutableList<Project> {

        val session = TransactionRunner.currentSession

        val hql= "from project"

        val query = session.createQuery(hql,Project::class.java)

        return query.resultList
    }
}