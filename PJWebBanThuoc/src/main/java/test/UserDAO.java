package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class UserDAO{
	public void create(User user) {
		EntityManager em = JpaUtils.getEntityManager();	
		EntityTransaction tran = em.getTransaction();
		
		try {
			tran.begin();
			
			em.persist(user);
			
			tran.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			tran.rollback();
			System.out.println("Lỗi trùng ID");
			throw e;
		}finally {
			em.close();
		}
		
	}
    public void update(User user) {
    	EntityManager em = JpaUtils.getEntityManager();
    	
    	EntityTransaction tran = em.getTransaction();
    	
    	try {
			tran.begin();
			
			em.merge(user);
			
			tran.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally {
			em.close();
		}
    }
//    
//    public void deleteAll() {
//    	EntityManager em = JpaUtils.getEntityManager();
//    	EntityTransaction tran = em.getTransaction();
//    	
//    	String  jqpl = "Delete from User";
//    	
//    	try {
//			tran.begin();
//			em.createQuery(jqpl).executeUpdate();
//			tran.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tran.rollback();
//		}
//    }
    
    public void delete(String id) throws Exception {
    	EntityManager em = JpaUtils.getEntityManager();
    	EntityTransaction tran = em.getTransaction();
    	
    	try {
			tran.begin();
			User user = em.find(User.class, id);
			if(user != null) {
				em.remove(user);
			}else {
				throw new Exception("This user does not exist!");
			}
			tran.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
    
    public List<User> findAll() {
    	EntityManager em = JpaUtils.getEntityManager();
    	String sql = "Select u from User u";
    	TypedQuery<User> query = em.createQuery(sql, User.class);
    	return query.getResultList();
	}
    
    public List<User> findByRole(boolean role) {
    	EntityManager em = JpaUtils.getEntityManager();
    	EntityTransaction tran = em.getTransaction();
    	
    	String jqpl = "Select o from User o where o.admin =:role";
    	TypedQuery<User> query = em.createQuery(jqpl, User.class);
    	query.setParameter("role", role);
    	
    	return query.getResultList();
		
	}
    
    public List<User> findBykeyWord(String keyword) {
    	EntityManager em = JpaUtils.getEntityManager();
    	EntityTransaction tran = em.getTransaction();
    	
    	String jqpl = "Select o from User o where o.fullname like ?0";
    	
    	TypedQuery<User> query = em.createQuery(jqpl,User.class);
    	query.setParameter(0, keyword);
    	return query.getResultList();
	}
    
    public User findOne(String id, String password) {
    	EntityManager em = JpaUtils.getEntityManager();
    	EntityTransaction tran = em.getTransaction();
    	String jqpl = "Select o from User o where o.id = :id And o.password=:pw";
    	TypedQuery<User> query = em.createQuery(jqpl, User.class);
    	query.setParameter("id", id);
    	query.setParameter("pw", password);
    	return query.getSingleResult();
    	
    }
	
}
