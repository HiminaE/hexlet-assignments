package exercise;

import io.javalin.Javalin;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("index.jte");
        });

        app.post("users", ctx -> {
            String firstName = ctx.formParam("firstName");
            String lastName = ctx.formParam("lastName");
            String email = ctx.formParam("email").toLowerCase().strip();
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");
            String capitalizeFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            String capitalizeLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            String encryptedPassword = Security.encrypt(password);

            User user = new User(capitalizeFirstName, capitalizeLastName, email, encryptedPassword);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
