import React from 'react'
import ProfileGraph from './ProfileGraph'

const Dive = ({ dive, samplePoints }) => {
  if (!dive || !samplePoints.length) {
    return null
  }

  const date = new Date(dive.date).toLocaleString('en-GB', {
    weekday: 'short',
    day: '2-digit',
    month: 'short',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
  const end = new Date(dive.endTime).toLocaleTimeString('en-GB', {
    hour: '2-digit',
    minute: '2-digit'
  })

  return (
    <div className="expandedDive">
      <ProfileGraph samplePoints={samplePoints} dive={dive} />
      <h3>Dive {dive.diveNum}</h3>
      <h3>
        {date} - {end}
      </h3>
      <p>
        {dive.place}, {dive.diveSite}
      </p>
      <p>{dive.notes}</p>
      <p>
        Buddy: {dive.buddy}, Air: {dive.airTemp}C, Surface: {dive.surfaceTemp}C,
        Bottom: {dive.bottomTemp}C, Boat: {dive.boat}, Weight: {dive.weight}Kgs
      </p>
    </div>
  )
}

export default Dive
