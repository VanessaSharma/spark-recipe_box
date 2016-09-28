import org.sql2o.*;
import java.util.List;

public class Recipe {
  public String name;
  public String description;
  public String ingredient;
  public String instruction;
  public int rating;
  public int id;


  public Recipe(String name, String description, String ingredient, String instruction, int rating) {
    this.name = name;
    this.description = description;
    this.ingredient = ingredient;
    this.instruction = instruction;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getIngredient() {
    return ingredient;
  }

  public String getInstruction() {
    return instruction;
  }

  public int getRating() {
    return rating;
  }

  public int getId() {
    return id;
  }
}
