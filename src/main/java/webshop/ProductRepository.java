package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class ProductRepository {
    private EntityManagerFactory entityManagerFactory;
    private DataSource dataSource;



    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    }

    public Product findProductById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Product item = em.find(Product.class, id);
        em.close();
        return item;
    }
    public long insertProduct(String productName, int price, int stock){
        EntityManager em = entityManagerFactory.createEntityManager();
        Product entity = new Product(productName,price,stock);
        System.out.println(entity.getId());
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity.getId();
    }


    public void updateProductStock(long id, int amount) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Product product = em.find(Product.class, id);
        em.getTransaction().begin();
        product.setStock(product.getStock()-amount);
        em.getTransaction().commit();
    }
}
