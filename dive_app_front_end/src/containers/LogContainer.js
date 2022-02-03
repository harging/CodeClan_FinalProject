import React, { useEffect, useState, useRef }  from "react";
import TitleBar from "../components/TitleBar";

const LogContainer = ({ baseUrl }) => {
    const [dives, setDives] = useState([]);
  
    useEffect(() => {
      loadDives(`${baseUrl}/dives`);
    },[])
  
    const loadDives = url => {
      fetch(url)
        .then(res => res.json())
        .then(divesList => setDives(divesList))
        .catch(err => console.error(err));
    }
    
    // Map round divesList, create an array of Dive components

    return (
      <>
        {/* Display dive components */}
      </>
    );
  }
  
  export default LogContainer;