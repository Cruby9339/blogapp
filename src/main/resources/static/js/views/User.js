import createView from "../createView.js";

export default function User(props) {
	return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Search and update</title>
</head>
<body>
<h1>Search</h1>

<form id="register-form">
	<label for="userId">Enter user ID</label>
	<input id="userId" name="userId" type="text">
    <label for="username">Search by Username</label>
    <input id="username" name="username" type="text"/>
    <label for="email">Search for Email</label>
    <input id="email" name="email" type="email"/>
    <h1>Update Password</h1>
    <label for="oldPassword">Old Password</label>
    <input id="oldPassword" name="oldPassword" type="password"/>
    <label for="newPassword" type="password"/>
    <input id="newPassword" name="newPassword" type="password"/>
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

function updatePassword() {
	$("#register-btn")
		.click(function () {
			let userOldPass = $("#oldPassword")
				.val()
			let userNewPass = $("#newPassword")

			let userId = $("#userId")
				.val()

			let request = {
				method: "GET",
				header: {"Content-Type": "application/json"}
			}

			fetch(`http://localhost:8080/api/users/${userId}/updatePassword?oldPassword=${userOldPass}&newPassword=${userNewPass}`)

		})
}