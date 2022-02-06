import React from 'react';
import TitleBar from './components/TitleBar';
import DiveContainer from './containers/DiveContainer';
import NewDiveContainer from './containers/NewDiveContainer'

function App() {
  
  return (
    <>
    <TitleBar /><NewDiveContainer />
    <DiveContainer />
    </>
  );
}

export default App;