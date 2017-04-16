import React from 'react'

const LoginButton = (props) => (
  <li>
    <form className="navbar-form navbar-left">
      <button className="btn btn-default" onClick={props.onClick}>
        Login
      </button>
    </form>
  </li>
)

const LogoutButton = (props) => (
  <li>
    <form className="navbar-form navbar-left">
      <button className="btn btn-default" onClick={props.onClick}>
        Logout
      </button>
    </form>
  </li>
)

export {LoginButton, LogoutButton}
