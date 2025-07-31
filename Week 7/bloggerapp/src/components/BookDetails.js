import React from "react";

const BookDetails = () => {
  const bookDetails = [
    {
      id: 1,
      type: "Book",
      title: "The Hobbit",
      author: "J.R.R. Tolkien",
      genre: "Fantasy",
      yearPublished: 1937,
      pages: 310,
    },
    {
      id: 2,
      type: "Book",
      title: "1984",
      author: "George Orwell",
      genre: "Dystopian",
      yearPublished: 1949,
      pages: 328,
    },
    {
      id: 3,
      type: "Book",
      title: "To Kill a Mockingbird",
      author: "Harper Lee",
      genre: "Fiction",
      yearPublished: 1960,
      pages: 281,
    },
  ];
  return (
    <div>
      <h3>Book Details</h3>
      <div className="detailsContainer">
        {bookDetails.map((book) => (
          <div key={book.id} className="tile">
            <h4>{book.title}</h4>
            <p>Author: {book.author}</p>
            <p>Genre: {book.genre}</p>
            <p>Year Published: {book.yearPublished}</p>
            <p>Pages: {book.pages}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BookDetails;
