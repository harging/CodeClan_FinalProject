import React from 'react';
import LogContainer from './containers/LogContainer';

function App() {
  const baseUrl = "http://localhost:8080"
  
  return (
    <LogContainer baseUrl={baseUrl} />
  );
}

export default App;