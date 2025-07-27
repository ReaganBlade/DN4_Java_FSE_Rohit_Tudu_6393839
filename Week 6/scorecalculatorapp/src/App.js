import React from 'react';
import { CalculateScore } from './components/CalculateScore';
import './stylesheets/mystyle.css';


const App = () => {
  return (
    <div>
        <CalculateScore name={"Steeve"} school={"DNV Public School"} total={284} goal={3} />

    </div>
  )
}

export default App