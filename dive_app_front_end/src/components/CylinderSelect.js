import React from 'react'

const CylinderSelect = ({ cylinders, onCylinderSelected }) => {
  return (
    <ul>
      {cylinders.map((cylinder) => {
        return (
          <li key={cylinder.id} className="cylinderListItem">
            <button onClick={() => onCylinderSelected(cylinder.id)}>
              {cylinder.dive}
              {cylinder.name}{' '}
            </button>
          </li>
        )
      })}
    </ul>
  )
}

export default CylinderSelect
