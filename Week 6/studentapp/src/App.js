import logo from "./logo.svg";
import "./App.css";
import Home from "./components/Home.js";
import Contact from "./components/Contact.js";
import About from "./components/About.js";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Home />
        <Contact />
        <About />
      </header>
    </div>
  );
}

export default App;
