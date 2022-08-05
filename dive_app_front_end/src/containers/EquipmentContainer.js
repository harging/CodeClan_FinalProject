import React from 'react'
import { useState, useEffect } from 'react'
import CylinderSelect from '../components/CylinderSelect'
import Cylinder from '../components/Cylinder'

const baseUrl = 'http://localhost:8080'

const EquipmentContainer = () => {
  const [cylinders, setCylinders] = useState([])
  const [selectedCylinderId, setSelectedCylinderId] = useState('')

  useEffect(() => {
    getCylinders(`${baseUrl}/cylinders`)
  }, [])

  const getCylinders = (url) => {
    fetch(url)
      .then((res) => res.json())
      .then((cylindersList) => setCylinders(cylindersList))
      .catch((err) => console.error(err))
  }

  const handleCylinderSelected = (id) => {
    setSelectedCylinderId(id)
  }

  const selectedCylinder = cylinders.find(
    (cylinder) => cylinder.id === selectedCylinderId
  )

  return (
    <>
      <Cylinder cylinder={selectedCylinder} />
      <CylinderSelect
        cylinders={cylinders}
        cylinder={selectedCylinder}
        onCylinderSelected={handleCylinderSelected}
      />
    </>
  )
}

export default EquipmentContainer
