@import exercise.dto.users.UsersPage

@param UsersPage page


<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUsers().isEmpty())
    <p>Пользователей нет</p>
@else
    <table>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
        </tr>
        @for(var user : page.getUsers())
            <tr>
                <td><a href="/users/${user.getId()}">${user.getFirstName()}</a></td>
                <td>${user.getLastName()}</td>
            </tr>
        @endfor
    </table>
@endif
</body>
</html>