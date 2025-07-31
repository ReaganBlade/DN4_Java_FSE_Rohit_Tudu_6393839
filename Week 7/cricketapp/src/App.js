import './index.css';
import ListofPlayers from './components/ListofPlayer';
import IndianPlayers from './components/IndianPlayers';

function App() {
  const flag = true;

  return (
    <div className="App">
      <h1>Welcome to the Player Management System</h1>
      {flag && <ListofPlayers />}
      <IndianPlayers />
    </div>
  );
}

export default App;