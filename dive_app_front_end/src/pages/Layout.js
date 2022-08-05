import { Outlet, Link } from 'react-router-dom'
import React from 'react'

const Layout = () => {
  return (
    <>
      <nav className="nav">
        {/* <h1 className="logo">.diveLogger</h1> */}
        <ul>
          <li className="logo">
            <Link to="/">.diveLogger</Link>
          </li>
          <li>
            <Link to="/createdive">Add Dive</Link>
          </li>
          <li>
            <Link to="/equipment">Equipment</Link>
          </li>
        </ul>
      </nav>
      <Outlet />
    </>
  )
}

export default Layout
