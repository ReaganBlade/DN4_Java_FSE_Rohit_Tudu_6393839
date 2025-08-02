import React, { useState } from 'react';


function Register() {
  
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
  });

  
  const [errors, setErrors] = useState({
    name: '',
    email: '',
    password: '',
  });

  
  const [isSubmitted, setIsSubmitted] = useState(false);

  /**
   * Validates a single field based on its name and value.
   * @param {string} name - The name of the input field (e.g., 'name', 'email').
   * @param {string} value - The current value of the input field.
   * @returns {string} - An error message if validation fails, otherwise an empty string.
   */
  const validateField = (name, value) => {
    switch (name) {
      case 'name':
        return value.length < 5 ? 'Name must be at least 5 characters long.' : '';
      case 'email':
        return !value.includes('@') || !value.includes('.') ? 'Please enter a valid email address.' : '';
      case 'password':
        return value.length < 8 ? 'Password must be at least 8 characters long.' : '';
      default:
        return '';
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;

    
    setFormData({
      ...formData,
      [name]: value,
    });

    
    const errorMessage = validateField(name, value);
    setErrors({
      ...errors,
      [name]: errorMessage,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault(); 

   
    const newErrors = {};
    let formIsValid = true;

    for (const key in formData) {
      const errorMessage = validateField(key, formData[key]);
      if (errorMessage) {
        newErrors[key] = errorMessage;
        formIsValid = false;
      }
    }

    
    setErrors(newErrors);

    
    if (formIsValid) {
      setIsSubmitted(true);
      console.log('Form submitted successfully:', formData);
      
    } else {
      setIsSubmitted(false);
      console.log('Form has validation errors.');
    }
  };

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>Register</h2>
      {isSubmitted ? (
        <div style={styles.successMessage}>Thank you for registering!</div>
      ) : (
        <form onSubmit={handleSubmit} noValidate>
          {/* Name Field */}
          <div style={styles.formGroup}>
            <label htmlFor="name" style={styles.label}>Name</label>
            <input
              type="text"
              id="name"
              name="name"
              value={formData.name}
              onChange={handleChange}
              style={styles.input}
              required
            />
            {errors.name && <p style={styles.error}>{errors.name}</p>}
          </div>

          {/* Email Field */}
          <div style={styles.formGroup}>
            <label htmlFor="email" style={styles.label}>Email</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              style={styles.input}
              required
            />
            {errors.email && <p style={styles.error}>{errors.email}</p>}
          </div>

          {/* Password Field */}
          <div style={styles.formGroup}>
            <label htmlFor="password" style={styles.label}>Password</label>
            <input
              type="password"
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              style={styles.input}
              required
            />
            {errors.password && <p style={styles.error}>{errors.password}</p>}
          </div>

          <button type="submit" style={styles.button}>Register</button>
        </form>
      )}
    </div>
  );
}


const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    padding: '40px',
    fontFamily: 'Arial, sans-serif',
    backgroundColor: '#f9f9f9',
    borderRadius: '8px',
    boxShadow: '0 4px 8px rgba(0,0,0,0.1)',
    maxWidth: '400px',
    margin: '50px auto',
  },
  title: {
    marginBottom: '20px',
    color: '#333',
  },
  formGroup: {
    marginBottom: '15px',
    width: '100%',
  },
  label: {
    display: 'block',
    marginBottom: '5px',
    color: '#555',
    fontWeight: 'bold',
  },
  input: {
    width: '100%',
    padding: '10px',
    border: '1px solid #ccc',
    borderRadius: '4px',
    boxSizing: 'border-box',
  },
  button: {
    width: '100%',
    padding: '12px',
    border: 'none',
    borderRadius: '4px',
    backgroundColor: '#007bff',
    color: 'white',
    fontSize: '16px',
    cursor: 'pointer',
    marginTop: '10px',
  },
  error: {
    color: 'red',
    fontSize: '12px',
    margin: '5px 0 0 0',
  },
  successMessage: {
    color: 'green',
    fontSize: '18px',
    fontWeight: 'bold',
  }
};

export default Register;
