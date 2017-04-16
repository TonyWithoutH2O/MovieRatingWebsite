import React, { Component } from 'react'

class Login extends Component {
  render() {
    return (
    	<div id="page-container">
        <div className="login bg-black animated fadeInDown">
          <div className="login-header">
            <div className="brand">
              <span className="logo"></span> Movie Rating Website
            </div>
          </div>
          <div className="login-content">
            <form className="margin-bottom-0" id="signinForm">
              <div className="form-group m-b-20">
                <input type="text" className="form-control input-lg" placeholder="Username" name="username" />
              </div>
              <div className="form-group m-b-20">
                <input type="text" className="form-control input-lg" placeholder="Password" name="password" />
              </div>
              <div className="checkbox m-b-20 hide">
                <label>
                  <input type="checkbox" /> Remember Me
                </label>
              </div>
              <div className="login-buttons">
                <button type="button" className="btn btn-success btn-block btn-lg">Sign me in</button>
              </div>
            </form>
          </div>
        </div>
    	</div>
    )
  }
}

export default Login
