import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {
  private Category category;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
    category = new Category("Fantasy");
  }

  @Test
  public void Category_instantiates_true() {
    assertEquals(true, category instanceof Category);
  }

  @Test
  public void getName_instantiatesWithCategoryName_Fantansy() {
    assertEquals("Fantasy", category.getName());
 }
 @Test
 public void save_returnsIdFromDatabase_true() {
   assertEquals(true, category.getId()>0);
 }
 @Test
 public void find_returnsCorrectCategory_true() {
   assertTrue(Category.find(category.getId()).getName().equals("Fantasy"));
 }
 @Test
 public void all_returnsAllInstances_true() {
   assertTrue(Category.all().size()>0);
 }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM categories *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
