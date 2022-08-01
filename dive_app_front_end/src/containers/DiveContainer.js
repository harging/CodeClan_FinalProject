import React from 'react';
import { useState, useEffect } from 'react';
import DiveSelect from '../components/DiveSelect';
import Dive from '../components/Dive';
import ProfileGraph from '../components/ProfileGraph';
import { isClass } from 'highcharts';

const baseUrl = 'https://dive-logger-back-end.herokuapp.com';

const DiveContainer = () => {
  const [dives, setDives] = useState([]);
  const [selectedDiveId, setSelectedDiveId] = useState(null);
  const [samplePoints, setSamplePoints] = useState([]);

  useEffect(() => {
    getDives();
  }, []);

  async function getDives() {
    const response = await fetch(`${baseUrl}/dives`);
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const dives = await response.json();
    setDives(dives);
  }

  const handleDiveSelected = (id) => {
    setSelectedDiveId(id);
    getSamplePoints(id);
    window.scrollTo({
      top: 400,
      left: 100,
      behavior: 'smooth'
    });
  };

  const getSamplePoints = (id) => {
    fetch(`${baseUrl}/samplepoints/bydiveid?diveid=${id}`)
      .then((res) => res.json())
      .then((samplePointsList) => setSamplePoints(samplePointsList))
      .catch((err) => console.error(err));
  };

  const selectedDive = dives.find((dive) => dive.id === selectedDiveId);

  return (
    <>
      {dives.length != 0 ? (
        <div className="home-page">
          <Dive dive={selectedDive} samplePoints={samplePoints} />
          <DiveSelect
            dives={dives}
            dive={selectedDive}
            onDiveSelected={handleDiveSelected}
          />
        </div>
      ) : (
        <div className="loading">
          Please wait around 15 seconds for the dives to load...
        </div>
      )}
    </>
  );
};

export default DiveContainer;
