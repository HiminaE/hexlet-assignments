package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import io.javalin.http.NotFoundResponse;
// import exercise.model.Post;
import exercise.repository.PostRepository;
import io.javalin.http.Context;

public class PostsController {
    //BEGIN
    public static void index(Context ctx) {
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var pageSize = 5;

        var sliceOfPosts = PostRepository.findAll(page, pageSize);

        var postPage = new PostsPage(sliceOfPosts, page);
        ctx.render("posts/index.jte", model("page", postPage));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    //END
}
