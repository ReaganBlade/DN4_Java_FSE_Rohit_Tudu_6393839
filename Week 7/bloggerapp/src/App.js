import "./App.css";
import React from "react";
import BlogDetails from "./components/BlogDetails";
import BookDetails from "./components/BookDetails";
import CourseDetails from "./components/CourseDetails";

function App() {
  return (
    <div className="App">
      <h1>Blogger App</h1>
      <div className="content">
        <BlogDetails />
        <BookDetails />
        <CourseDetails />
      </div>
    </div>
  );
}

export default App;
