import createView from "../createView.js";

export default function user(props) {
	return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Search</h1>

<form id="register-form">
    <label for="username">Search by Username</label>
    <input id="username" name="username" type="text"/>
    <label for="email">Email</label>
    <input id="email" name="email" type="email"/>
    <label for="password">Update Password</label>
    <input id="password" name="password" type="password"/>
    <button type="button" id="register-btn">Search</button>
</form>
</body>
</html>`;

}


export function SearchEvent() {
	searchForUser()
}

function searchForUser() {
	$("#register-btn")
		.click(function () {
			let userName = $("#username")
				.val()

			let request = {
				method: "GET",
				header: {"Content-Type": "application/json"}
			}

			fetch(`http://localhost:8080/api/users/findByUsername?username=${userName}`, request)
				.then((response) => {
					console.log(response)
				})
				.catch(error => {
					console.log(error)
				})


		})
}