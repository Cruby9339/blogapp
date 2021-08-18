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

<form id="search-form">
	<label for="userId">Enter user ID</label>
	<input id="userId" name="userId" type="text">
    <label for="username">Search by Username</label>
    <input id="username" name="username" type="text"/>
    <label for="email">Search for Email</label>
    <input id="email" name="email" type="email"/>
    <button type="button" id="search-btn">Search</button>
    <h1>Update Password</h1>
    <label for="oldPassword">Old Password</label>
    <input id="oldPassword" name="oldPassword" type="password"/>
    <label for="newPassword" type="password"/>
    <input id="newPassword" name="newPassword" type="password"/>
    <button type="button" id="update-btn">Search</button>
</form>
</body>
</html>`;

}


export function SearchEvent() {
	searchForUser()
	updatePassword()
}

function searchForUser() {
	$("#search-btn")
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
	$("#update-btn")
		.click(function () {
			let userPassObj = {
				userId: $("#userId")
					.val(),
				userOldPass: $("#oldPassword")
					.val(),
				userNewPass: $("#newPassword")
					.val()
			}

			let request = {
				method: "PUT",
				headers: {"Accept": "application/json",
					"Content-Type": "application/json"},
				Body: JSON.stringify(userPassObj)
			}

			//http://localhost:8080/api/users/1/updatePassword?oldPassword=pw123&newPassword=pw1234

			fetch(`http://localhost:8080/api/users/${userPassObj.userId}/updatePassword?oldPassword=${userPassObj.userOldPass}&newPassword=${userPassObj.userNewPass}`, request)
				.then((response) => {
					console.log(response)
					createView("/users");
				})
				.catch(error => {
					console.log(error)
					createView("/users")
				})

		})
}