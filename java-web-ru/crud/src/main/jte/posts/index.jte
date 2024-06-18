@import exercise.dto.posts.PostsPage
@param PostsPage page


@template.layout.page (
content = @`

    @if(page.getPosts().isEmpty())
        <h1>Пока не добавлено ни одного поста</h1>
    @endif
    <table class="table table-striped">
        @for(var post : page.getPosts())
            <tr>
                <td>
                    ${post.getId()}
                </td>
                <td>
                    <a href="/posts/${post.getId()}">${post.getName()}</a>
                </td>
                <td>
                    ${post.getBody()}
                </td>
            </tr>
        @endfor
    </table>

    <nav class="navbar">
        <div class="menu">
            <a href="/posts?page=${page.getPageNumber() - 1}">Предыдущая</a>
        </div>
        <div class="menu">
            <a href="/posts?page=${page.getPageNumber() + 1}">Следующа</a>
        </div>
    </nav>
`)
