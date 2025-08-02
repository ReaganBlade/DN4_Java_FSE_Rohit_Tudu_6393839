// src/components/App.js
import React, { useState } from 'react';
import { ThemeContext } from './context/ThemeContext';
import EmployeesList from './components/EmployeesList';
import './App.css'; // Import App specific styles

function App() {
  // State to hold the current theme ('light' or 'dark')
  const [theme, setTheme] = useState('light');

  // Function to toggle the theme
  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    // The Provider makes the theme value available to all child components
    <ThemeContext.Provider value={theme}>
      <div className="app-container">
        <header className="app-header">
          <div>
            <h1 className="header-title">Employee Dashboard</h1>
            <p className="header-subtitle">Manage your team with ease.</p>
          </div>
          {/* This button now correctly uses the theme for its own style */}
          <button onClick={toggleTheme} className={`btn btn-${theme}`}>
            Toggle to {theme === 'light' ? 'Dark' : 'Light'} Mode
          </button>
        </header>

        <main>
          <EmployeesList />
        </main>
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
