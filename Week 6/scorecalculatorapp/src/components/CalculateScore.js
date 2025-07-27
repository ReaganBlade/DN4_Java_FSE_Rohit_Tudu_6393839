import React from "react";

const percentToDecimal = (decimal) => {
  return (decimal.toFixed(2) + '%');
}

const calcScore = (total, goal) => {
  return percentToDecimal(total/goal);
}

export const CalculateScore = ({ name, school, total, goal }) => {
  return <div className="formatstyle">
    <h1><font color="Brown">Student Details: </font></h1>
    <div className="Name">
        <b><span>Name: </span></b>
        <span>{name}</span>
    </div>
    <div className="School">
      <b><span>School: </span></b>
      <span>{school}</span>
    </div>
    <div className="Total">
      <b><span>Total: </span>
      <span>{total}</span>
      <span>Marks</span>
      </b>
    </div>
    <div className="Score">
      <b>Score: </b>
      <span>
        {calcScore(
          total, goal
        )}
      </span>
    </div>
  </div>;
};
