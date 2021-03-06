import React, { Component } from 'react'
import PropTypes from 'prop-types';
import ApplicationConsumer from '../context';
import ApplicationService from '../services/ApplicationService';

class ApplicationComponent extends Component {
    state = {
        isVisible : false 
    }

    onClickEvent = (e) =>{ 
        this.setState(
            {
                isVisible : !this.state.isVisible
            }
        )
        //console.log(number) 
    }
    onDeleteApplication = (dispatch,e) =>{
        const{applicationID} = this.props;
        //Consumer Dispatch
        console.log("Silinen verinin id'si:",applicationID);
        dispatch({type : "DELETE_APPLICATION",payload : applicationID}); 
    }
    componentDidMount(){
        ApplicationService.getApplications().then((response) => {

            this.setState({  applications : response.data});
            
        });
    }
    render() {
        const { applicationID, shortCode, releaseDate, responsible, lcOfBackendCode, lcOfFrontendCode, lineStopRisk, livePlantsCount, plantApp } = this.props;
        const { isVisible} = this.state;
        return (
            <ApplicationConsumer> 
            {
                value =>{
                    const{dispatch} = value;
                    return (
                        <div className = "col-md-8 mb-4">
                            <div className = "card"  style = {isVisible ? {backgroundColor : "#62848d", color : "white"} : null}>
                                <div className = "card-header d-flex justify-content-between">
                                    <h4 className = "d-inline" onClick = {this.onClickEvent}> {shortCode}</h4>
                                    <button onClick={this.onDeleteApplication.bind(this,dispatch)} className = "fas fa-trash-alt"  style = {{cursor : "pointer"}}></button> 
                                </div>
                                {
                                 isVisible ? 
                                <div className = "card-body">
                                    <p className = "card-text">Application ID: {applicationID}</p>
                                    <p className = "card-text">Short Code: {shortCode}</p>
                                    <p className = "card-text">Release Date: {releaseDate}</p>
                                    <p className = "card-text">Responsible: {responsible}</p>
                                    <p className = "card-text">Lc of Backend Code: {lcOfBackendCode}</p>
                                    <p className = "card-text">Lc of Frontend Code: {lcOfFrontendCode}</p>
                                    <p className = "card-text">Line Stop Risk: { String(lineStopRisk) }</p>
                                    <p className = "card-text">Live Plants Count: {livePlantsCount}</p>
                                    <p>***</p>
                                </div> : null 
                                }
                            </div>
                        </div> 
                    )
                }
            } 
            </ApplicationConsumer>
        )
    }
}
ApplicationComponent.defaultProps = {
    shortCode : "B??LG?? YOK",
    releaseDate : "B??LG?? YOK",
    responsible : "B??LG?? YOK",
    lcOfBackendCode: "B??LG?? YOK",
    lcOfFrontendCode: "B??LG?? YOK",
    lineStopRisk: "B??LG?? YOK",
    livePlantsCount: "B??LG?? YOK",
}
ApplicationComponent.propTypes = {
    applicationID: PropTypes.number,
    shortCode: PropTypes.string.isRequired,
    releaseDate: PropTypes.string.isRequired,
    responsible: PropTypes.string.isRequired,
    lcOfBackendCode: PropTypes.string.isRequired,
    lcOfFrontendCode: PropTypes.string.isRequired,
    lineStopRisk: PropTypes.bool.isRequired,
    livePlantsCount: PropTypes.number.isRequired,

    plantApp : PropTypes.array.isRequired,
}
export default ApplicationComponent;
