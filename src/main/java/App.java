import java.util.Map;
import java.util.HashMap;
import java.util.List;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
       port = Integer.parseInt(process.environment().get("PORT"));
    } else {
       port = 4567;
    }

    setPort(port);

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("categories", Category.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Category category = new Category(request.queryParams("category"));
      model.put("categories", Category.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/products/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("categoryId", Integer.parseInt(request.params(":id")));
      model.put("products", Product.allByCategory(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/product.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/products/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Product product = new Product(request.queryParams("name"),request.queryParams("description"), Integer.parseInt(request.params(":id")), Float.parseFloat(request.queryParams("cost")));
      model.put("categoryId", Integer.parseInt(request.params(":id")));
      model.put("products", Product.allByCategory(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/product.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/customers", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("customers", Customer.all());
      model.put("template", "templates/customers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/customers/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Customer customer = Customer.find(Integer.parseInt(request.params(":id")));
      int id = Integer.parseInt(request.params(":id"));
      Customer.find(id).setFirstName(request.queryParams("first"));
      Customer.find(id).setLastName(request.queryParams("last"));
      Customer.find(id).setPhoneNumber(request.queryParams("phone"));
      Customer.find(id).setAddress(request.queryParams("address"));
      Customer.find(id).setCity(request.queryParams("city"));
      Customer.find(id).setState(request.queryParams("state"));
      Customer.find(id).setZip(Integer.parseInt(request.queryParams("zip")));
      Customer.find(id).setEmail(request.queryParams("email"));

      model.put("customer", Customer.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/customer.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/customers/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("customer", Customer.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/customer.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/customers", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();


      Customer customer = new Customer(
        request.queryParams("first"),
        request.queryParams("last"),
        request.queryParams("phone"),
        request.queryParams("address"),
        request.queryParams("city"),
        request.queryParams("state"),
        Integer.parseInt(request.queryParams("zip")),
        request.queryParams("email")
      );
      model.put("customers", Customer.all());
      model.put("template", "templates/customers.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
