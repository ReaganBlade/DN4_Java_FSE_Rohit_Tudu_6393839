import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    async loadPosts() {
        try {
            const response = await fetch("https://jsonplaceholder.typicode.com/posts");
            if (!response.ok) {
                throw new Error("Failed to fetch posts");
            }
            const rawPosts = await response.json();
            
            const posts = rawPosts.map(
                item => new Post(item.id, item.title, item.body)
            );
            this.setState({ posts });
        } catch (err) {
            this.setState({ error: err });
        }
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert(`An error occurred: ${error.message}`);
    }

    render() {
        if (this.state.error) {
            return <h2>Error: {this.state.error.message}</h2>;
        }
        return (
            <div>
                <h1>Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{marginBottom: '20px'}}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
