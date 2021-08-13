export default function PostIndex(props) {
	return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <form>
        
		</form>
        <main>
            <div>
                ${props.posts.map(post => `<h3>${post.title}</h3>`)
					   .join('')}   
            </div>
            
            
            
        </main>
    `;
}