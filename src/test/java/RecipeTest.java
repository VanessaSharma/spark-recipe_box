import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CustomerTest {
  private Customer customer;
  private Customer customer2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/bookstore_test", null, null);
    customer = new Customer("Karen", "Freeman", "503-331-2346", "1710 Henderson Ave", "Eugene", "OR", 97403, "karen@sample.com");
    customer2 = new Customer("Karen", "Smith", "503-883-9533", "5392 Knightwood Drive", "Klamath Falls", "OR", 97603, "ksmith@sample.com");
  }

  @Test
  public void Customer_instantiates_true() {
    assertEquals(true, customer instanceof Customer);
  }


  @Test
  public void getFirstName_returnsCorrectName_String() {
    assertEquals("Karen", customer.getFirstName());
  }

  @Test
  public void setFristName_updatesName_String() {
    customer2.setFirstName("Steve");
    assertEquals("Steve", Customer.find(customer2.getId()).getFirstName());
  }

  @Test
  public void getLastName_returnsCorrectName_String() {
    assertEquals("Freeman", customer.getLastName());
  }

  @Test
  public void setLastName_updatesName_String() {
    customer2.setFirstName("Freeman");
    assertEquals("Freeman", Customer.find(customer2.getId()).getFirstName());
  }

  @Test
  public void getPhoneNumber_returnsCorrectPhoneNumber_String() {
    assertEquals("503-331-2346", customer.getPhoneNumber());
  }

  @Test
  public void setPhoneNumber_updatesPhoneNumber_String() {
    customer2.setPhoneNumber("503-331-2346");
    assertEquals("503-331-2346", Customer.find(customer2.getId()).getPhoneNumber());
  }

  @Test
  public void getAddress_returnsCorrectAddress_String() {
    assertEquals("1710 Henderson Ave", customer.getAddress());
  }

  @Test
  public void setAddress_updatesAddress_String() {
    customer2.setAddress("1710 Henderson Ave");
    assertEquals("1710 Henderson Ave", Customer.find(customer2.getId()).getAddress());
  }


  @Test
  public void getCity_returnsCorrectCity_String() {
    assertEquals("Eugene", customer.getCity());
  }

  @Test
  public void setCity_updatesCity_String() {
    customer2.setCity("Eugene");
    assertEquals("Eugene", Customer.find(customer2.getId()).getCity());
  }

  @Test
  public void getState_returnsCorrectState_String() {
    assertEquals("OR", customer.getState());
  }

  @Test
  public void setState_updatesState_String() {
    customer2.setState("CA");
    assertEquals("CA", Customer.find(customer2.getId()).getState());
  }

  @Test
  public void getZip_returnsCorrectZip_int() {
    assertEquals(97403, customer.getZip());
  }

  @Test
  public void setZip_updatesZip_int() {
    customer2.setZip(97403);
    assertEquals(97403, Customer.find(customer2.getId()).getZip());
  }

  @Test
  public void getEmail_returnsCorrectEmail_String() {
    assertEquals("karen@sample.com", customer.getEmail());
  }

  @Test
  public void setEmail_updatesEmail_String() {
    customer2.setEmail("karen@sample.com");
    assertEquals("karen@sample.com", Customer.find(customer2.getId()).getEmail());
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, customer.getId()>0);
  }

  @Test
  public void find_returnCorrectCustomer_true() {
    assertTrue(Customer.find(customer.getId()).getEmail().equals(customer.getEmail()));
  }

  @Test
  public void all_returnsAllInstances_true() {
    assertTrue(Customer.all().size()>1);
  }

  @Test
  public void delete_deletesCustomer_true() {
    int customerId = customer2.getId();
    Customer.delete(customerId);
    assertEquals(null, Customer.find(customerId));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM customers *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
