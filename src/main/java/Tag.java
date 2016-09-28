import org.sql2o.*;
import java.util.List;

public class Tag {
  public String name;
  public int id;


  public Tag(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
}
