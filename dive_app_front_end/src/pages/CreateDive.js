import React, { useState } from 'react'
import Loading from '../components/Loading'

const CreateDive = () => {
  const [diveFile, setDiveFile] = useState(null)

  const sendFile = (e) => {
    e.preventDefault()

    const formData = new FormData()
    formData.append('excelfile', diveFile)

    const requestOptions = {
      method: 'POST',
      body: formData
    }
    fetch('http://localhost:8080/uploaddives', requestOptions).then(
      (response) => console.log(response)
    )
  }

  return (
    <>
      <div className="file-upload-form">
        <form onSubmit={sendFile}>
          <input type="file" onChange={(e) => setDiveFile(e.target.files[0])} />
          <input type="submit" value="Save dive" />
        </form>
      </div>
      <Loading diveFile={diveFile} />
    </>
  )
}

export default CreateDive
