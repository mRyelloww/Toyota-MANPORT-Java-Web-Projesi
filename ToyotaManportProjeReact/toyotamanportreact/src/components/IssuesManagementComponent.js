import React, { Component } from 'react'
import IssueConsumer from '../IssueContext.js';
import Moment from 'moment';


class IssuesManagementComponent extends Component {
    render() {
        return (
            <IssueConsumer>
                {
                    value => {
                        const { issues } = value;
                        return (
                            <div className="page-content-wrapper-inner mx-5">
                                <div className="content-viewport">

                                    <div className="row">

                                        <div className="col-6 py-5">
                                            <h4>Issues</h4>
                                            <p className="text-gray">Issues takip ekranı.</p>
                                        </div>
                                        <div className="grid-application">
                                            <button className="btn btn-dark btn-black mb-1 "> Search </button>
                                        </div>
                                    </div>

                                    <div className="col-12 management-px-5">
                                        <div className="grid">
                                            {/* <p className="grid-header">Application Management</p> */}
                                            <div className="item-wrapper">
                                                <table className="table table-striped">
                                                    <thead>
                                                        <tr >
                                                            <th>Date</th>
                                                            <th>App Name</th>
                                                            <th>Issue Type</th>
                                                            <th>Impact</th>
                                                            <th>Plant</th>
                                                            <th>Desription</th>
                                                            <th style={{ textAlign: "center" }}>Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        {
                                                            issues.map(issue => {
                                                                return (
                                                                    <tr >
                                                                        <td>{Moment(issue.date).format('D-MM-YYYY H:m')}</td>
                                                                        <td>{issue.plantApp.application.shortCode}</td>
                                                                        <td>{issue.issueJobType.map(issueJob=>{return( issueJob.jobName )})}</td>
                                                                        <td>{issue.issueJobType.map(issueJob=>{return( issueJob.impact.impactLevel )})}</td>
                                                                        <td>{issue.plantApp.plant.country.countryName}</td>
                                                                        <td>{issue.description}</td>
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
            </IssueConsumer>
        )
    }
}
export default IssuesManagementComponent;
