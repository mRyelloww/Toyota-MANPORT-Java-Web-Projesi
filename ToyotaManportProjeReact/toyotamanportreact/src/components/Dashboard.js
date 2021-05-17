import React, { Component } from 'react';
import ApplicationConsumer from "../context.js";
import PlantAppComponent from './PlantAppComponent.js';


class Dashboard extends Component {
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
                                        <div className="col-12 py-5">
                                            <h4>Dashboard</h4>
                                            <p className="text-gray">Uygulama durumlarının canlı olarak izlenebildiği ekran.</p>
                                        </div>
                                    </div>

                                    <div className="row">
                                        {
                                            applications.map((application, index) => {
                                                return (
                                                    <div key={index} className="col-md-6 equel-grid">
                                                        <div className="grid">

                                                            <div className="grid-body py-3 split-header" style={{ backgroundColor: "#c7c5bf" }}>
                                                                <p className="card-title ml-n1 text-black"> {application.shortCode} </p>
                                                                <div className="btn-group">
                                                                    <button type="button" className="btn action-btn btn-xs component-flat pr-0 text-black"
                                                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                        SHOW
                                                                    </button><i className="mdi mdi-chevron-down mr-n1 ml-2"></i>
                                                                </div>
                                                            </div>
                                                            <PlantAppComponent
                                                                applicationID={application.applicationID}
                                                            />
                                                            { /* 
                                                                <div className="col-3 equel-grid pt-2">
                                                                    <div className="grid">
                                                                        <div className="grid-body text-black py-0 px-0">

                                                                            <div className="plant" style={{ backgroundColor: "#c7c5bf" }}>
                                                                                <p className="text-black text-center"> TURKEY </p>
                                                                            </div>

                                                                            <div className="equel-grid">
                                                                                <div className="grid mt-1 mb-0">
                                                                                    <div className="grid-body text-black pt-0 px-0">

                                                                                        <div className="prod" style={{ backgroundColor: "#c7c5bf" }}>
                                                                                            <p className="text-black text-center">PROD-1</p>
                                                                                        </div>

                                                                                        <div className="container row mx-0 px-0">

                                                                                            <div className="col-4 equel-grid pt-1 px-0">
                                                                                                <div className="grid my-0">
                                                                                                    <div className="grid-body text-black py-0 px-0">
                                                                                                        <div className="job" style={{ backgroundColor: "#00ff00" }}>
                                                                                                            <p className="text-black text-center">Job1</p>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>

                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                */}

                                                        </div>
                                                    </div>
                                                )
                                            })

                                        }
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
export default Dashboard;