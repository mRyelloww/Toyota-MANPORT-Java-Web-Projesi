import React, { Component } from 'react'
import PropTypes from 'prop-types';
import PlantAppConsumer from '../PlantAppContext.js';
import PlantAppService from '../services/PlantAppService.js';
import JobIssueComponent from './JobIssueComponent.js'
import IssueConsumer from '../IssueContext.js';
import IssueService from '../services/IssueService.js';
import axios from 'axios';




class PlantAppComponent extends Component {
    updatePlantAppDatabase(plantapp,impactLvlID){
        const data ={
            "plantAppID":plantapp.plantAppID,
            "alive":plantapp.alive,
            "impact":impactLvlID,
            "application":plantapp.application,
            "plant":plantapp.plant
        }
        axios.put("http://localhost:8080/deneme/plantapp/1",data)

    }
    componentDidMount() {
        PlantAppService.getPlantApps().then((response) => {
            this.setState({ plantapps: response.data });
        });
        IssueService.getIssues().then((response) => {
            this.setState({ issues: response.data });
        });
    }
    /*
    prodTitleColor(prod) {
        var prodHighestImpactLevel = 0;
        var impactID = 0;
        prod.jobs.map(job => {
            //console.log("Selammmss"+job.impact.impactID);
            impactID = job.impact.impactID;
            console.log("ImpactID : " + impactID)

            if (impactID > prodHighestImpactLevel) {
                prodHighestImpactLevel = impactID
            }
        })
        switch (prodHighestImpactLevel) {
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
    }*/
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
    plantTitle(plantapp) {
        var prodsHighestImpacts = [];
        return (
            <IssueConsumer>
                {
                    value => {

                        plantapp.plant.productions.map(plantAppProd => {

                            const { issues } = value;
                            var prodEnYuksekImpactLevel = 0;

                            issues.map(issue => {
                                if (issue.plantApp != null) { // ????erisinde veri bulundurmayan bir Issue olu??turulmu?? olabilir.O y??zden bu condition var.
                                    if (plantapp.plantAppID === issue.plantApp.plantAppID) {
                                        issue.plantApp.plant.productions.map(prod => {
                                            if (prod.productionID === plantAppProd.productionID) {
                                                issue.issueJobType.map(jobInIssue => {
                                                    prod.jobs.map(job => {
                                                        if (jobInIssue.jobID === job.jobID) {
                                                            if (jobInIssue.impact.impactID > prodEnYuksekImpactLevel) {
                                                                prodEnYuksekImpactLevel = jobInIssue.impact.impactID
                                                                prodsHighestImpacts.push(prodEnYuksekImpactLevel);
                                                            }
                                                        }
                                                    })
                                                })
                                            }
                                        })
                                    }
                                    else {
                                        prodsHighestImpacts.push(1);
                                    }
                                }
                            })

                        })
                        var sonKarar = 0;
                        prodsHighestImpacts.map(data => {
                            if (data > sonKarar) {
                                sonKarar = data;
                            }
                        })
                        return (
                            <div className="plant" style={{ backgroundColor: this.impactaGoreRenkAl(sonKarar) }}>
                                { this.updatePlantAppDatabase(plantapp,sonKarar) }
                                <p className="text-black text-center"> {plantapp.plant.country.countryName /*+ sonKarar*/} </p>
                            </div>
                        )
                    }
                }
            </IssueConsumer>

        )
    }
    prodTitle(plantAppID, prodName, prodID, jobID) {
        return (
            <IssueConsumer>
                {
                    value => {
                        const { issues } = value;
                        var match = false;
                        var prodEnYuksekImpactLevel = 1;

                        issues.map(issue => {
                            if (issue.plantApp != null) { // ????erisinde veri bulundurmayan bir Issue olu??turmu?? olabilir.O y??zden bu condition var.
                                if (plantAppID == issue.plantApp.plantAppID) {
                                    issue.plantApp.plant.productions.map(prod => {
                                        if (prodID === prod.productionID) {
                                            issue.issueJobType.map(jobInIssue => {
                                                prod.jobs.map(job => {
                                                    if (jobInIssue.jobID === job.jobID) {
                                                        if (jobInIssue.impact.impactID > prodEnYuksekImpactLevel) {
                                                            prodEnYuksekImpactLevel = jobInIssue.impact.impactID
                                                        }
                                                    }
                                                })
                                            })
                                        }
                                    })
                                }
                            }
                        })
                        return (
                            <div className="prod" style={{ backgroundColor: this.impactaGoreRenkAl(prodEnYuksekImpactLevel) }}>
                                <p className="text-black text-center"> {prodName /*+ " ID:" + prodID*/} </p>
                            </div>
                        )

                    }
                }
            </IssueConsumer>
        )
    }

    render() {
        const { applicationID } = this.props;
        return (
            <PlantAppConsumer>
                {
                    value => {
                        const { plantapps } = value;

                        return (
                            <div className="container row mx-0 px-n1">
                                {
                                    plantapps.map(plantapp => {
                                        return (
                                            applicationID == plantapp.application.applicationID ?
                                                <div className="col-3 equel-grid pt-2">
                                                    {
                                                        <div className="grid">
                                                            {
                                                                <div className="grid-body text-black py-0 px-0">

                                                                    {this.plantTitle(plantapp)}

                                                                    {
                                                                        plantapp.plant.productions.map(prod => {
                                                                            return (
                                                                                <div className="equel-grid">
                                                                                    <div className="grid mt-1 mb-0">
                                                                                        <div className="grid-body text-black pt-0 px-0">


                                                                                            {this.prodTitle(plantapp.plantAppID, prod.productionName, prod.productionID, prod.jobID, "forProd")}

                                                                                            <div className="container row mx-0 px-0">
                                                                                                {prod.jobs.map(job => {
                                                                                                    return (
                                                                                                        <div className="col-4 equel-grid pt-1 px-0">
                                                                                                            <div className="grid my-0">
                                                                                                                <div className="grid-body text-black py-0 px-0">
                                                                                                                    <JobIssueComponent
                                                                                                                        applicationID={plantapp.application.applicationID}
                                                                                                                        plantID={plantapp.plant.plantID}
                                                                                                                        prodID={prod.productionID}
                                                                                                                        jobID={job.jobID}
                                                                                                                        jobName={job.jobName}
                                                                                                                    />
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    )
                                                                                                })}
                                                                                            </div>

                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            )
                                                                        })
                                                                    }
                                                                </div>
                                                            }
                                                        </div>
                                                    }
                                                </div>
                                                : null
                                        )
                                    })
                                }
                            </div>
                        )
                    }
                }
            </PlantAppConsumer>
        )
    }
}
PlantAppComponent.defaultProps = {
    plantAppID: "B??LG?? YOK",
    alive: "B??LG?? YOK",
}
PlantAppComponent.propTypes = {
    plantAppID: PropTypes.number,
    alive: PropTypes.bool.isRequired,

    application: PropTypes.array,
    plant: PropTypes.array,
    issues: PropTypes.array,

}
export default PlantAppComponent;

{/*
    <p className="card-text">Plant App ID: {plantapp.plantAppID}</p>
    <p> PlantApp'in i??indeki ApplicationID: {plantapp.application.applicationID}</p>
    <p> Gelen ApplicationID: {applicationID} </p>
    <p> Plant Name: {plantapp.plant.country.countryName} </p>
    <p className="card-text">Alive: {String(plantapp.alive)}</p>
    <p>***</p>
*/}