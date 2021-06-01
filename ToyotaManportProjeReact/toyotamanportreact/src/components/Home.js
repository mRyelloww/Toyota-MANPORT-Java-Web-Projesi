import React, { Component } from 'react'
import axios from 'axios';
import dashboard from '../assets/images/images/dashboard.png'
import management from '../assets/images/images/management.png'
import issues from '../assets/images/images/issues.png'
import { Link } from 'react-router-dom'




class Home extends Component {
    render() {
        return (
            <div className="page-content-wrapper-inner mx-5">
                <div className="content-viewport">
                    <div className="row">
                        <div className="col-12 py-5" style={{ textAlign: 'center' }}>
                            <h4> Ana Sayfa Ekranı</h4>
                            <p className="text-gray"></p>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col-md-4 home">
                            <Link to="/dashboard">
                                <div className="grid-home">
                                    <img src={dashboard} />
                                </div>
                            </Link>
                        </div>
                        <div className="col-md-4 home">
                            <Link to="/management">
                                <div className="grid-home">
                                    <img src={management} />
                                </div>
                            </Link>
                        </div>
                        <div className="col-md-4 home">
                            <Link to="/issuesManagement">

                                <div className="grid-home">
                                    <img src={issues} />
                                </div>
                            </Link>
                        </div>

                    </div>

                </div>
            </div>
        )
    }
}
export default Home;
