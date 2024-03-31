package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controller.JpaUtil;
import entity.Clazz;

public class clazzImplement implements IDao<Clazz>{

	@Override
	public void create(Clazz entity) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(Clazz entity) {
	    EntityManager em = JpaUtil.getEntityManager();
	    try {
	        em.getTransaction().begin();
	        em.merge(entity);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        em.getTransaction().rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	@Override
	public Clazz delete(String id) {
	    EntityManager em = JpaUtil.getEntityManager();
	    Clazz clazz = null;
	    try {
	        em.getTransaction().begin();
	        clazz = em.find(Clazz.class, id);
	        if (clazz != null) {
	            em.remove(clazz);
	        }
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        em.getTransaction().rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	    return clazz;
	}


	@Override
	public Clazz findById(String id) {
		EntityManager em = JpaUtil.getEntityManager();
	    Clazz clazz = null;
	    try {
	        clazz = em.find(Clazz.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        em.close();
	    }
	    return clazz;
		
	}

	@Override
	public List<Clazz> findAll() {
		  EntityManager em = JpaUtil.getEntityManager();
		    List<Clazz> clazzList = null;
		    try {
		        Query query = em.createQuery("SELECT c FROM Clazz c");
		        clazzList = query.getResultList();
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        em.close();
		    }
		    return clazzList;
		
	}

	@Override
	public int count() {
		  EntityManager em = JpaUtil.getEntityManager();
		    long count = 0;
		    try {
		        Query query = em.createQuery("SELECT COUNT(c) FROM Clazz c");
		        count = (long) query.getSingleResult();
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw e;
		    } finally {
		        em.close();
		    }
		    return (int) count;
		
	}

}
