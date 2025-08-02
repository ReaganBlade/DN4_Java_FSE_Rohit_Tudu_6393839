import React from "react";

const BlogDetails = () => {
  const blogDetails = [
    {
      id: 1,
      type: "Blog",
      title: "Understanding React Hooks",
      author: "Jane Doe",
      category: "Web Development",
      datePosted: "2023-04-12",
      readTime: 8,
    },
    {
      id: 2,
      type: "Blog",
      title: "A Guide to Healthy Eating",
      author: "John Smith",
      category: "Lifestyle",
      datePosted: "2023-05-20",
      readTime: 5,
    },
    {
      id: 3,
      type: "Blog",
      title: "The Future of Artificial Intelligence",
      author: "Sam Wilson",
      category: "Technology",
      datePosted: "2023-06-01",
      readTime: 12,
    },
  ];
  return (
    <div>
      <h3>Blog Details</h3>
      <div className="detailsContainer">
        {blogDetails.map((blog) => (
          <div key={blog.id} className="tile">
            <h4>{blog.title}</h4>
            <p>Author: {blog.author}</p>
            <p>Category: {blog.category}</p>
            <p>Date Posted: {blog.datePosted}</p>
            <p>Read Time: {blog.readTime} minutes</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BlogDetails;
