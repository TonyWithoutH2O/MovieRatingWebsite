import React, { Component } from 'react'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/css/bootstrap-theme.css'
import './App.css'

import BasicRouter from './router/router.js'

class App extends Component {
  render() {
    return (
      <BasicRouter className="App">
      </BasicRouter>
    )
  }
}

export default App
