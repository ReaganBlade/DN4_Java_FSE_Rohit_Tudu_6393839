// src/App.js
import { useState } from 'react';
import EmployeesList from './components/EmployeesList';
import ThemeContext from './context/ThemeContext'; // Import the ThemeContext [cite: 30]
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    // Provide the theme context to the entire component tree [cite: 31]
    <ThemeContext.Provider value={theme}>
      <div className={`App ${theme}`}>
        <header className="App-header">
          <h1>Employee Management</h1>
          <button onClick={toggleTheme}>
            Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
          </button>
        </header>
        {/* The theme prop is no longer passed to EmployeesList */}
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;