import React, { Component } from 'react';
import ApplicationComponent from "./ApplicationComponent";
import ApplicationConsumer from "../context.js";
import ApplicationService from "../services/ApplicationService.js";
import axios from "axios";


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
                                applications.map((application,index) => {
                                    if(index === 0){
                                        //application.shortCode = "CAN";
                                    }
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
