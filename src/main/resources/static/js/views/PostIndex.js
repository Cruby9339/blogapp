import createView from "../createView.js";


export default function PostIndex(props) {
	return `
		<div class="container">
        <header>
            <h1>Posts Page</h1>
        </header>
   		<form action="">
   		<label for="title-create">Post Title:</label>
   		<input id="title-create" type="text"><br>
   		<label for="content-create">Post Content:</label>
   		<input id="content-create" type="text"><br>
   		<select>
   		
		</select>
   		<button id="submit-btn">Submit</button>
		</form>
		<form>
		<input id="post-by-cat" type="text">
		<button id="search-by-cat">Search By Category</button>
		</form>
        <main>
            <div class="post-container">
            
                ${getPostsComponent(props.posts)}   
            </div>
   		
        </main>
        </div>
    `;
}

function getPostsComponent(posts) {
	return posts.map(post => {
		return `
					<div class="row mt-3"><h2 class="col-4">${post.user.username}</h2><h2 class="col-4">${post.title}</h2> <h2 class="col-4">${post.content}</h2>
					
					<div class="categories">
					${getCategoriesComponent(post.categories)}
					
					</div>
					
					<label for="edit-title">Edit Title</label>
					<input type="text" class="edit-title" value="${post.title}" readonly> 
					<label for="edit-content">Edit Content</label>
					<input type="text" class="edit-content" value="${post.content}" readonly> 
					<button data-id="${post.id}" class="edit-btn btn btn-primary mt-1">Edit</button>
   					<button data-id="${post.id}" class="delete-btn btn btn-primary mt-1">Delete</button></div>`
	})
				.join('')
}

function getCategoriesComponent(categories) {

	return categories.map(category =>
		`
		<span>#${category.name}</span>

		`
	)
}


export function PostEvent() {
	createEvent()
	editEvent()
	deleteEvent()
	searchCategories()
}


function createEvent() {
	$("#submit-btn")
		.click(function () {
			let title = $("#title-create")
				.val()
			let content = $("#content-create")
				.val()

			let postObj = {
				"title": title,
				"content": content
			}

			console.log(postObj)

			let request = {
				method: "POST",
				headers: {"Content-Type": "application/json"},
				body: JSON.stringify(postObj)
			}
			fetch("http://localhost:8080/api/posts", request)
				.then(res => {
					console.log(res.status)
					createView("/posts")
				})
				.catch(error => {
					console.log(error);
					createView("/posts")
				})
		})
}


function editEvent() {
	$(".edit-btn")
		.click(function () {
			console.log("edit event fired off")
			$(".edit-btn")
				.text("Edit")
			$(".edit-title, .edit-content")
				.attr("readonly", true)
			$(this)
				.siblings(".edit-title, .edit-content")
				.attr("readonly", false)
			$(this)
				.text("Save");

			$(this)
				.on("click", submitEditEvent)


		})
}


function submitEditEvent() {
	let post = {
		title: $(this)
			.siblings(".edit-title")
			.text(),
		content: $(this)
			.siblings(".edit-content")
			.text()
	}
	let request = {
		method: "PUT",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(post)
	}
	console.log(request)

	$(this)
		.off("click", submitEditEvent)

	let id = $(this)
		.attr("data-id")

	fetch(`http://localhost:8080/api/posts/${id}`, request)
		.then(res => {
			console.log(res.status);
			createView("/posts");
		})
		.catch(error => {
			console.log(error)
			createView("/posts")
		})
}


function deleteEvent() {
	$(".delete-btn")
		.click(function () {

			let request = {
				method: "DELETE",
				headers: {"Content-Type": "application/json"},
			}

			let id = $(this)
				.attr("data-id")

			fetch(`http://localhost:8080/api/posts/${id}`, request)
				.then(res => {
					console.log(res.status);
					createView("/posts");
				})
				.catch(error => {
					console.log(error)
					createView("/posts")
				})
		})
}

function searchCategories() {
	$("#search-by-cat")
		.click(function () {
			let categoryName = $("#post-by-cat")
				.val()

			let request = {
				method: "GET",
				headers: {"Content-Type": "application/json"}
			}

			//http://localhost:8080/api/categories?categoryName=Tech

			fetch(`http://localhost:8080/api/categories?categoryName=${categoryName}`, request)
				.then(res => {
					console.log(res.status);
					createView("/posts");
				})
				.catch(error => {
					console.log(error)
					createView("/posts")
				})
		})

}