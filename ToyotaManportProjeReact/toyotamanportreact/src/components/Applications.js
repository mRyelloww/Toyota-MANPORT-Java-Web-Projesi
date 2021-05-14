import React, { Component } from 'react';
import ApplicationComponent from "./ApplicationComponent";
import ApplicationConsumer from "../context.js";

class Applications extends Component {
    render() {

        return(
            <ApplicationConsumer>
            { 
                value =>{
                    const {applications} = value;
                    return (
                        <div>
                            {
                                applications.map(application => {
                                    return (
                                        <ApplicationComponent
                                            key              = {application.applicationID}
                                            applicationID    = {application.applicationID}
                                            shortCode        = {application.shortCode}
                                            releaseDate      = {application.releaseDate}
                                            responsible      = {application.responsible} 
                                            lcOfBackendCode  = {application.lcOfBackendCode} 
                                            lcOfFrontendCode = {application.lcOfFrontendCode}
                                            lineStopRisk     = {application.lineStopRisk} 
                                            livePlantsCount  = {application.livePlantsCount}

                                            /*plantApp         = {application.plantApp}*/
                                            
                                        />
                                    )
                                }
                                )
                            }
                        </div>
                    )
                }
            }
            </ApplicationConsumer>
        )
    }
}
export default Applications;
