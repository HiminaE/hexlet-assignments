@import exercise.dto.users.UserPage

@param UserPage page


<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getUser().getId()}</h1>
<p>${page.getUser().getFirstName()}</p>
<p>${page.getUser().getLastName()}</p>
<p>${page.getUser().getEmail()}</p>
</body>
</html>