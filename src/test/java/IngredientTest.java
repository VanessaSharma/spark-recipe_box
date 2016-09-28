import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ProductTest {
  private Product product = new Product("My Little Dragon", "A fantastic story about a little dragon in Narnia.", 1, 2);

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
  }

  @Test
  public void Product_instantiates_true() {
    assertEquals(true, product instanceof Product);
  }
  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM products *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
