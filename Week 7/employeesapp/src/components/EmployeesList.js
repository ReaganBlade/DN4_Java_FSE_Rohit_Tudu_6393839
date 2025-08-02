import React from "react";
import EmployeeCard from "./EmployeeCard";

const EmployeesList = () => {
  const mockEmployees = [
    {
      id: 1,
      name: "Alice Johnson",
      title: "Software Engineer",
      department: "Technology",
      avatar: "https://placehold.co/100x100/7B46E4/FFFFFF?text=AJ",
    },
    {
      id: 2,
      name: "Bob Williams",
      title: "Project Manager",
      department: "Management",
      avatar: "https://placehold.co/100x100/E4467B/FFFFFF?text=BW",
    },
    {
      id: 3,
      name: "Charlie Brown",
      title: "UX/UI Designer",
      department: "Design",
      avatar: "https://placehold.co/100x100/46E47B/FFFFFF?text=CB",
    },
    {
      id: 4,
      name: "Diana Prince",
      title: "QA Tester",
      department: "Technology",
      avatar: "https://placehold.co/100x100/E47B46/FFFFFF?text=DP",
    },
  ];
  return (
    <div className="employees-list-grid">
      {mockEmployees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
};

export default EmployeesList;
