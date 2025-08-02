"use client";

import React, { useState, useEffect } from "react";

const GetUser = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  
  useEffect(() => {
    const fetchUser = async () => {
      try {
        const user_uri = "https://api.randomuser.me";
        const response = await fetch(user_uri);

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const data = await response.json();
        
        setUser(data.results[0]); 
        
      } catch (e) {
        setError(e.message);
        console.error("Error fetching user:", e);
      } finally {
        setLoading(false);
      }
    };

    fetchUser();
  }, []); 

  
  if (loading) {
    return <div>Loading user...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div>
      <h1>User Profile</h1>
      {user ? (
        <div>
          <img src={user.picture.large} alt="User" />
          <p>Name: {user.name.first} {user.name.last}</p>
          <p>Email: {user.email}</p>
        </div>
      ) : (
        <p>No user data found.</p>
      )}
    </div>
  );
};

export default GetUser;
