import React, { useEffect, useState } from "react";

const ComplainRegister = () => {
  const [name, setName] = useState("");
  const [complaint, setComplaint] = useState("");
  const [complaints, setComplaints] = useState([]);

  useEffect(() => {
    const stored = JSON.parse(localStorage.getItem("complaints")) || [];
    setComplaints(stored);
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!name.trim() || !complaint.trim()) {
        alert("Please fill in both fields.");

        return;
    }

    const refNumber = Math.floor(100000 + Math.random() * 900000);
    const newComplaint = {
        name,
        complaint,
        refNumber,
        timestamp: new Date().toISOString(),
    };

    const updated = [...complaints, newComplaint];
    setComplaints(updated);
    localStorage.setItem('complaints', JSON.stringify(updated));

    alert(`Complaint submitted!\nReference Number: ${refNumber}`);

    setName('');
    setComplaint('');
  }

  return (
    <div style={{ maxWidth: '500px', margin: 'auto' }}>
      <h2>Register a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name:</label><br />
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            style={{ width: '100%', padding: '8px' }}
            required
          />
        </div>
        <div style={{ marginTop: '10px' }}>
          <label>Complaint:</label><br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            rows="5"
            style={{ width: '100%', padding: '8px' }}
            required
          />
        </div>
        <button type="submit" onSubmit={handleSubmit} style={{ marginTop: '15px', padding: '10px 20px' }}>
          Submit Complaint
        </button>
      </form>
    </div>
  );
};

export default ComplainRegister;
