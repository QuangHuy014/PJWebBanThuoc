package test;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




public class UserDAO{
	@Override
	protected void finalize() throws Throwable {
		EntityManager em = JpaUtils.getEntityManager();
		em.close();
		super.finalize();
	}

	public void create(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void update(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void delete(String id) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			User user = em.find(User.class, id);
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

//	public User findById(String id) {
//		EntityManager em = JpaUtils.getEntityManager();
//		User entity = em.find(User.class, id);
//		return entity;
//	}
	public User findById(String tendangnhap) {
	    EntityManager em = JpaUtils.getEntityManager();
	    try {
	        String jpaQuery = "SELECT u FROM User u WHERE u.tendangnhap = :tendangnhap";
	        TypedQuery<User> query = em.createQuery(jpaQuery, User.class);
	        query.setParameter("tendangnhap", tendangnhap);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null; // Trả về null nếu không tìm thấy user
	    } finally {
	        em.close();
	    }
	}

	

//	public User checkLogin(String id, String password) {
//		EntityManager em = JpaUtils.getEntityManager();
//		String japl = "select u from User u where u.Id = :Id and u.Password = :Password";
//		TypedQuery<User> query = em.createQuery(japl, User.class);
//		query.setParameter("id", id);
//		query.setParameter("password", password);
//		return query.getSingleResult();
//	}
	public User checkLogin(String tendangnhap, String matkhau) {
	    EntityManager em = JpaUtils.getEntityManager();
	    try {
	        String jpaQuery = "SELECT u FROM User u WHERE u.tendangnhap = :tendangnhap AND u.matkhau = :matkhau";
	        TypedQuery<User> query = em.createQuery(jpaQuery, User.class);
	        query.setParameter("tendangnhap", tendangnhap);
	        query.setParameter("matkhau", matkhau);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null; // Trả về null nếu không tìm thấy user
	    } finally {
	        em.close();
	    }
	}



	public List<User> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	public List<User> findByFullname(String fullname) {
	    EntityManager em = JpaUtils.getEntityManager();
	    String jpaQuery = "SELECT u FROM User u WHERE u.fullname LIKE :fullname";
	    TypedQuery<User> query = em.createQuery(jpaQuery, User.class);
	    query.setParameter("fullname", "%" + fullname + "%");
	    return query.getResultList();
	}

//// ghi chú
	public List<User> findAll(int page, int pageSize) {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
	    query.setFirstResult(page * pageSize);
	    query.setMaxResults(pageSize);
	    return query.getResultList();
	}

//	public List<User> findByFullname(String fullname, int page, int pageSize) {
//	    EntityManager em = JpaUtils.getEntityManager();
//	    String jpaQuery = "SELECT u FROM User u WHERE u.fullname LIKE :fullname";
//	    TypedQuery<User> query = em.createQuery(jpaQuery, User.class);
//	    query.setParameter("fullname", "%" + fullname + "%");
//	    query.setFirstResult(page * pageSize);
//	    query.setMaxResults(pageSize);
//	    return query.getResultList();
//	}

	public long countAll() {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM User u", Long.class);
	    return query.getSingleResult();
	}


	

	public int count() {
		EntityManager em = JpaUtils.getEntityManager();
		String japl = "select count( u) from User u ";
		Query query = em.createQuery(japl);
		return ((Long) query.getSingleResult()).intValue();
	}
	
}
