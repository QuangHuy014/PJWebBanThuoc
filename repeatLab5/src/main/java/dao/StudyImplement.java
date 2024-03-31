package dao;

import entity.Study;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controller.JpaUtil;

import java.util.List;

public class StudyImplement implements IDao<Study> {

    @Override
    public void create(Study entity) {
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
    public void update(Study entity) {
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
    public Study delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Study study = null;
        try {
            em.getTransaction().begin();
            study = em.find(Study.class, id);
            if (study != null) {
                em.remove(study);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return study;
    }

    @Override
    public Study findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Study study = null;
        try {
            study = em.find(Study.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
        return study;
    }

    @Override
    public List<Study> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Study> studyList = null;
        try {
            Query query = em.createQuery("SELECT s FROM Study s");
            studyList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
        return studyList;
    }

    @Override
    public int count() {
        EntityManager em = JpaUtil.getEntityManager();
        long count = 0;
        try {
            Query query = em.createQuery("SELECT COUNT(s) FROM Study s");
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

