import React from 'react';
import { useState, useEffect } from 'react'
import DiveSelect from '../components/DiveSelect'
import Dive from '../components/Dive'
import ProfileGraph from '../components/ProfileGraph'
import { isClass } from 'highcharts'

const baseUrl = "http://localhost:8080"

const DiveContainer = () => {

    const [dives, setDives] = useState([])
    const [selectedDiveId, setSelectedDiveId] = useState('')

    useEffect(() => {
        getDives(`${baseUrl}/dives`)
    }, [])
    
    const getDives = url => {
              fetch(url)
                .then(res => res.json())
                .then(divesList => setDives(divesList))
                .catch(err => console.error(err));
            }

    const handleDiveSelected = id => {
        setSelectedDiveId(id)
    }

    const selectedDive = dives.find(dive => dive.id === selectedDiveId)

    return (

        <>
            <Dive dive={selectedDive}/>
            {/* <ProfileGraph dive={selectedDive}/> */}
            <DiveSelect dives={dives} dive={selectedDive} onDiveSelected={handleDiveSelected} />
        </>
    )
}

export default DiveContainer