export default function Navbar(props) {
	return `
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a href="/" class="nav-link" data-link>Home</a>
            <a href="/posts" class="nav-link" data-link>Posts</a>
            <a href="/about" class="nav-link" data-link>About</a>
            <a href="/login" class="nav-link" data-link>Login</a>
            <a href="/users" class="nav-link" data-link>Users</a>
        </nav>
    `;
}