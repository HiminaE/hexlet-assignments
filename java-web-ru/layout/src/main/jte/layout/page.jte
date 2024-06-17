@import gg.jte.Content
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Layout</title>
</head>
<body>
<p>
    <a href="/">Home page</a>
    <a href="/users">Users</a>
</p>
<div class="mx-auto p-4 py-md-5">
    ${content}
</div>
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif
</body>
</html>