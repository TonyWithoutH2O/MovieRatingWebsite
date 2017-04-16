import React, { Component } from 'react'
import {
  Link
} from 'react-router-dom'
import {LoginButton, LogoutButton} from '../component/loginBtn.js'

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = {isLoggedIn: false};
  }

  handleLoginClick() {
    this.setState({isLoggedIn: true});
  }

  handleLogoutClick() {
    this.setState({isLoggedIn: false});
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;

    let button = null;
    if (isLoggedIn) {
      button = <LogoutButton onClick={this.handleLogoutClick} />
      return (
        <ul className="nav navbar-nav">
          <li><Link to="/">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/topics">Topics</Link></li>
          {button}
        </ul>
      )
    } else {
      button = <LoginButton onClick={this.handleLoginClick} />
      return (
        <ul className="nav navbar-nav">
          <li><Link to="/login">Login</Link></li>
          {button}
        </ul>
      )
    }
  }
}

export default Navbar
