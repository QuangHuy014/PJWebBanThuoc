package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
  public static EntityManager getEntityManager() {
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebBanThuoc");
	  
	  return emf.createEntityManager();
  }
}
