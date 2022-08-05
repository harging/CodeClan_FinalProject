import React from 'react'

const DiveSelect = ({ dives, onDiveSelected }) => {
  return (
    <ul>
      {dives.map((dive) => {
        return (
          <li key={dive.id} className="diveListItem">
            <button onClick={() => onDiveSelected(dive.id)}>
              {dive.diveNum} - {dive.place}, {dive.diveSite}
            </button>
          </li>
        )
      })}
    </ul>
  )
}

export default DiveSelect
