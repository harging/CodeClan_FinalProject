import React from 'react'

const Loading = ({ diveFile }) => {
  if (!diveFile) {
    return <div></div>
  } else {
    console.log(diveFile)
    return <div>Loading...</div>
  }
}

export default Loading
