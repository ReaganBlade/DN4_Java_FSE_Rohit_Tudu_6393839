import React from "react";

const CourseDetails = () => {
  const courseDetails = [
    {
      id: 1,
      type: "Course",
      title: "Introduction to Python",
      instructor: "Dr. Angela Yu",
      subject: "Programming",
      durationHours: 55,
      level: "Beginner",
    },
    {
      id: 2,
      type: "Course",
      title: "Advanced JavaScript Concepts",
      instructor: "Maximilian Schwarzmüller",
      subject: "Web Development",
      durationHours: 48,
      level: "Advanced",
    },
    {
      id: 3,
      type: "Course",
      title: "Graphic Design Masterclass",
      instructor: "Lindsay Marsh",
      subject: "Design",
      durationHours: 30,
      level: "Intermediate",
    },
  ];

  return (
    <div>
      <h3>Blog Details</h3>
      <div className="detailsContainer">
        {courseDetails.map((courses) => (
          <div key={courses.id} className="tile">
            <h4>{courses.title}</h4>
            <p>Instructor: {courses.instructor}</p>
            <p>Subject: {courses.subject}</p>
            <p>Duration: {courses.durationHours} hours</p>
            <p>Level: {courses.level}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CourseDetails;
