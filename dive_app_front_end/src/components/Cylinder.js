import React from 'react'

const Cylinder = ({ cylinder }) => {
  if (!cylinder) {
    return null
  }

  return (
    <div className="expandedCylinder">
      <h3>Name {cylinder.name}</h3>
      <p>{cylinder.notes}</p>
    </div>
  )
}

export default Cylinder
