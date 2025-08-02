import React, { useContext } from "react";
import ThemeContext from "../context/ThemeContext";

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext);

  const buttonStyle = {
    color: theme === "dark" ? "#fff" : "#000",
    background: theme === "dark" ? "#333" : "#fff",
    border: `1px solid ${theme === "dark" ? "#fff" : "#000"}`,
    padding: "8px 16px",
    cursor: "pointer",
    margin: "5px",
  };

  return (
    <div
      style={{
        border: "1px solid #ccc",
        padding: "16px",
        margin: "16px 0",
        borderRadius: "8px",
      }}
    >
      <h4>{EmployeeCard.name}</h4>
      <p>ID: {employee.id} </p>
      <p>Email: {employee.email} </p>
      <button style={buttonStyle}>Details</button>
      <button style={buttonStyle}>Delete</button>
    </div>
  );
};

export default EmployeeCard;
