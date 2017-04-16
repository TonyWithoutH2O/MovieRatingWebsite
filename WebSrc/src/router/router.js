import React from 'react'
import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom'
import Home from '../component/home.js'
import Login from '../component/login.js'
import About from '../component/about.js'
import Topics from '../component/topics.js'
import Navbar from './navbar.js'

const BasicRouter = () => (
  <Router>
    <div>
      <nav className="navbar navbar-default">
        <div className="container-fluid">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <a className="navbar-brand" href="#">Brand</a>
          </div>
          <div className="collapse navbar-collapse">
            <Navbar></Navbar>
          </div>
        </div>
      </nav>

      <hr/>

      <Route exact path="/" component={Home}/>
      <Route path="/login" component={Login}/>
      <Route path="/about" component={About}/>
      <Route path="/topics" component={Topics}/>
    </div>
  </Router>
)
export default BasicRouter
