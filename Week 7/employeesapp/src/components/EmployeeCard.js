// src/components/EmployeeCard.js
import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';

const EmployeeCard = ({ employee }) => {
  // Use the useContext hook to get the current theme from the context.
  const theme = useContext(ThemeContext);

  return (
    <div className="employee-card">
      <div className="employee-avatar-container">
        <img className="employee-avatar" src={employee.avatar} alt={`${employee.name}'s avatar`} />
      </div>
      <div className="employee-details">
        <div className="employee-name">{employee.name}</div>
        {/* Corrected the typo in the className below */}
        <p className="employee-title">{employee.title}</p>
        <p className="employee-department">{employee.department}</p>
        <div className="employee-actions">
          {/* The theme from context correctly sets the button's class */}
          <button className={`btn btn-${theme}`}>Message</button>
          <button className={`btn btn-${theme}`}>View Profile</button>
        </div>
      </div>
    </div>
  );
};

export default EmployeeCard;
