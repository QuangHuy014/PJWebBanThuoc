package dao;


import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import controller.JpaUtil;

import java.util.List;

public class StudentImplement implements IDao<Student> {

    @Override
    public void create(Student entity) {
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
    public void update(Student entity) {
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
    public Student delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = null;
        try {
            em.getTransaction().begin();
            student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        return student;
    }

    @Override
    public Student findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = null;
        try {
            student = em.find(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> studentList = null;
        try {
            Query query = em.createQuery("SELECT s FROM Student s");
            studentList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
        return studentList;
    }

    @Override
    public int count() {
        EntityManager em = JpaUtil.getEntityManager();
        long count = 0;
        try {
            Query query = em.createQuery("SELECT COUNT(s) FROM Student s");
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
