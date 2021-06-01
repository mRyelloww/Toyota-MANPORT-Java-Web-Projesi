import React, { Component } from 'react'
import toyo from '../../assets/images/images/toyo.jpg'
import { Link } from 'react-router-dom'

export default class Sidebar extends Component {
    render() {
        return (
            <div className="sidebar">
                <div className="user-profile">
                    <div>
                        <Link to="/home">
                            <img src={toyo} />
                        </Link>
                    </div>
                </div>
                <ul className="navigation-menu">
                    <li className="nav-category-divider">MENU</li>

                    <li>
                        <Link to="/home">
                            <span className="link-title">Home </span>
                            <i className="mdi mdi-home link-icon"></i>
                        </Link>
                    </li>
                    <li>
                        <Link to="/dashboard">
                            <span className="link-title">Dashboard</span>
                            <i className="mdi mdi-gauge link-icon"></i>
                        </Link>
                    </li>
                    <li>
                        <Link to="/management">
                            <span className="link-title">Management</span>
                            <i className="mdi mdi-wrench link-icon"></i>
                        </Link>

                    </li>

                    <li>
                        <Link to="/issuesManagement">
                            <span className="link-title">Issues</span>
                            <i className="mdi mdi-alert link-icon"></i>
                        </Link>
                    </li>

                    <li>
                        <Link to="/home">
                            <span className="link-title">Links</span>
                            <i className="mdi mdi-link-variant link-icon"></i>
                        </Link>

                    </li>

                    <li className="nav-category-divider">DOCS</li>
                    <li>
                        <Link to="/addApp">
                                <span className="link-title">Documentation</span>
                                <i className="mdi mdi-asterisk link-icon"></i>
                        </Link>
                    </li>
                </ul>
            </div>

        )
    }
}

