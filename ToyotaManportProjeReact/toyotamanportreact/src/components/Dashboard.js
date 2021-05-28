import React, { Component } from 'react';
import ApplicationConsumer from "../context.js";
import PlantAppComponent from './PlantAppComponent.js';
import PlantAppConsumer from '../PlantAppContext.js';
import LastIssuesComponent from "./LastIssuesComponent.js";
import posed from 'react-pose';
import axios from 'axios';


const Animation = posed.div(
    {
        visible: {
            opacity: 1,
            applyAtStart: {
                display: "block"
            }
        },
        hidden: {
            opacity: 0,
            applyAtEnd: {
                display: "none"
            }
        }
    }
);
class Dashboard extends Component {
    //state={
    //    visible : true,
    //}
    updateApplicationDatabase(application) {
        const data = {
            "applicationID": application.applicationID,
            "shortCode": application.shortCode,
            "relaseDate": application.relaseDate,
            "responsible": application.responsible,
            "lcOfBackendCode": application.lcOfBackendCode,
            "lcOfFrontendCode": application.lcOfFrontendCode,
            "lineStopRisk": application.lineStopRisk,
            "livePlantsCount": application.livePlantsCount,
            "visibility": true,
            "middleWare": application.middleWare,
            "frontend": application.frontend,
            "backend": application.backend,
            "databaseName": application.databaseName,
            "responsibleTeam": application.responsibleTeam,
            "businessArea": application.businessArea
        }
        axios.put("http://localhost:8080/deneme/application/1", data)
    }
    changeVisibility(application, highestImpactLevel) {
        //console.log(String(!application.visibility));
        if (highestImpactLevel > 1) {
            this.updateApplicationDatabase(application);
        }
    }
    impactaGoreRenkAl(impactLevel) {
        switch (impactLevel) {
            case 4:
                return "#cc0000";
            case 3:
                return "#ffa500";
            case 2:
                return "#ffff00";
            case 1:
                return "#049c0c";
            default:
                return "#c7c5bf";
        }
    }
    applicationTitleColor(application) {
        return (
            <PlantAppConsumer>{
                value => {
                    const { plantapps } = value;
                    var applicationImpacts = [];
                    var applicationHighestImpact = 1;
                    plantapps.map(plantapp => {
                        if (plantapp.application.applicationID === application.applicationID) {
                            applicationImpacts.push(plantapp.impact);
                        }
                    })
                    applicationImpacts.map(impactlvl => {
                        if (impactlvl > applicationHighestImpact) {
                            applicationHighestImpact = impactlvl;
                        }
                    })
                    return (
                        <div className="grid-body py-3 split-header" style={{ backgroundColor: this.impactaGoreRenkAl(applicationHighestImpact) }}>
                            <p className="card-title ml-n1 text-black"> {application.shortCode} </p>
                            {this.changeVisibility(application, applicationHighestImpact)}
                            <div className="btn-group">
                                <button type="button" className="btn action-btn btn-xs component-flat text-black"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i className="mdi mdi-chevron-double-down mr-n1 ml-2"></i>
                                </button>
                            </div>
                        </div>
                    )
                }
            }
            </PlantAppConsumer>
        )
    }
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
                                            <h4>Dashboard</h4>
                                            <p className="text-gray">Uygulama durumlarının canlı olarak izlenebildiği ekran.</p>
                                        </div>
                                        <LastIssuesComponent />
                                    </div>

                                    <div className="row">
                                        {
                                            applications.map((application, index) => {
                                                return (
                                                    <div key={index} className="col-md-6 equel-grid">
                                                        <div className="grid">

                                                            {this.applicationTitleColor(application)}
                                                            <Animation pose={application.visibility ? "visible" : "hidden"}>
                                                                <PlantAppComponent
                                                                    applicationID={application.applicationID}
                                                                />
                                                            </Animation>
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