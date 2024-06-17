@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h2>Users List</h2>

    @if(page.getUsers().isEmpty())
        <p>Users not found</p>
    @else
        <table>
            <thead>
            <tr>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`,
footer = @`
    <p>Himina Elena</p>
    <p><a href="https://github.com/HiminaE">My GitHub profile</a></p>
`
)