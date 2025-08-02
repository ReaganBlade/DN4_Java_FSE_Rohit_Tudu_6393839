import React from "react";

const OfficeDetails = () => {
  const officeList = [
    { id: 1, location: "Downtown", size: 2000, rent: 5500 },
    { id: 2, location: "Midtown", size: 1500, rent: 4500 },
    { id: 3, location: "Uptown", size: 3000, rent: 8000 },
    { id: 4, location: "Suburbs", size: 2500, rent: 3500 },
  ];

  return (
    <div>
      <h2>Available Office Spaces</h2>
      <div className="office-details">
        {officeList.map((office) => (
          <div>
            <h2>Office Details</h2>
            <p>Location: {office.location}</p>
            <p>Size: {office.size} sq ft</p>
            <p style={{ color: office.rent < 6000 ? "red" : "green" }}>
              Price: ${office.rent}/month
            </p>
          </div>
        ))}
        {/* 
      <h2>Office Space Details</h2>
      <p>Location: {officeDetails.location}</p>
      <p>Size: {officeDetails.size} sq ft</p>
      <p style={{ color: officeDetails.rent < 6000 ? 'red' : 'green' }}>
        Price: ${officeDetails.rent}/month
      </p> 
      */}
      </div>
    </div>
  );
};

export default OfficeDetails;
