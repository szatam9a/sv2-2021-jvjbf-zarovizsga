package webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class ProductRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    Product findProductById(long id) {
        return (jdbcTemplate.queryForObject("select * from products where id = ?",
                (rs, rowNum) -> new Product(rs.getLong("id"), rs.getString("product_name"),
                        rs.getInt("price"), rs.getInt("stock"))
                , id));
    }

    public long insertProduct(String productName, int price, int stock) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into products(product_name,price,stock) values(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.executeUpdate();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) return rs.getLong(1);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        throw new IllegalArgumentException("No id error");
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("update products  set stock = stock -? where id = ? ", amount, id);
    }
}
