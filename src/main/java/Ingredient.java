import org.sql2o.*;
import java.util.List;

public class Ingredient {
  public String name;
  public int id;

  public Ingredient(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
}
