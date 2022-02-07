import React from 'react';
import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import NoPage from "./pages/NoPage";
import TitleBar from './components/TitleBar';
import DiveContainer from './containers/DiveContainer';
import Layout from './pages/Layout';
import CreateDive from './pages/CreateDive'
import Equipment from './pages/Equipment'

function App() {
  
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="createdive" element={<CreateDive />} />
          <Route path="equipment" element={<Equipment />} />
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;