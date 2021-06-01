import React, { Component } from 'react'
import ApplicationConsumer from '../context';
import { Link } from 'react-router-dom'



class ManagementComponent extends Component {
    render() {
        return (
            <ApplicationConsumer>
                {
                    value => {
                        const { applications } = value;
                        return (
                            <div className="page-content-wrapper-inner mx-5">
                                <div className="content-viewport">

                                    <div className="row">

                                        <div className="col-6 py-5">
                                            <h4>Management</h4>
                                            <p className="text-gray">Uygulama yönetim ekranı.</p>
                                        </div>
                                        <div className="grid-application">
                                            <Link to="/addApplication">
                                                <button className="btn btn-dark btn-black mb-1 "> Add New App </button>
                                            </Link>
                                        </div>
                                        <div className="grid-application">
                                            <Link to="/plantManagement">
                                                <button className="btn btn-dark btn-black mb-1 "> Plant Management </button>
                                            </Link>
                                        </div>
                                    </div>

                                    <div className="col-12 management-px-5">
                                        <div className="grid">
                                            {/* <p className="grid-header">Application Management</p> */}
                                            <div className="item-wrapper">
                                                <table className="table table-striped">
                                                    <thead>
                                                        <tr >
                                                            <th>Application Name</th>
                                                            <th>Business Area</th>
                                                            <th>Live Plants</th>
                                                            <th>Line Stop Risk</th>
                                                            <th style={{ textAlign: "center" }}>Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        {
                                                            applications.map(application => {
                                                                return (
                                                                    <tr >
                                                                        <td>{application.shortCode}</td>
                                                                        <td>{application.businessArea.businessAreaName}</td>
                                                                        <td>{application.livePlantsCount}</td>
                                                                        <td>{String(application.lineStopRisk)}</td>
                                                                        <td className="actions" style={{ textAlign: "center" }}>
                                                                            <i className="mdi-set mdi-eye link-icon col-3"></i>
                                                                            <i className="mdi-set mdi-tooltip-edit col-3"></i>
                                                                            <i className="mdi-set mdi-delete-forever col-3"></i>
                                                                            <i className="mdi-set mdi-bookmark col-3"></i>
                                                                        </td>
                                                                    </tr>
                                                                )
                                                            })
                                                        }
                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        )
                    }
                }
            </ApplicationConsumer>
        )
    }
}
export default ManagementComponent;