import React, { Component } from 'react'
import posed from 'react-pose';
import ApplicationConsumer from "../context";
import Applications from './Applications';
var uniqid = require('uniqid');



const Animation = posed.div(
    {
        visible : {
            opacity : 1,
            applyAtStart : {
                display : "block"
            }
        },
        hidden : {
            opacity : 0,
            applyAtEnd : {
                display : "none"
            }
        }
    }
);
class AddApplication extends Component {

    state = {
        visible : true,
        shortCode : "",
        releaseDate : "",
        responsible : "",
        lcOfBackendCode : "",
        lcOfFrontendCode : "",
        lineStopRisk : "",
        livePlantsCount : "",

    }
    changeVisibility = (e) =>{
        this.setState({
            visible : !this.state.visible
        })
    }
    changeInput = (e) =>{
        this.setState({
            [e.target.name] : e.target.value
        })
    }
    addApplication = (dispatch,e) => {
        e.preventDefault();
        const {shortCode, releaseDate, responsible, lcOfBackendCode, lcOfFrontendCode, lineStopRisk, livePlantsCount} = this.state;
        const newApplication = {id : uniqid() , shortCode, releaseDate, responsible, lcOfBackendCode, lcOfFrontendCode, lineStopRisk, livePlantsCount}
        console.log(newApplication);
        dispatch({type : "ADD_APPLICATION",payload : newApplication});
    }
    /*
    changeName = (e) =>{
        this.setState({
            name : e.target.value
        })
    }
    changeDepartment= (e) =>{
        this.setState({
            department : e.target.value
        })
    }
    changeSalary= (e) =>{
        this.setState({
            salary : e.target.value
        })
    }*/

    render() {
        const {visible,shortCode, releaseDate, responsible, lcOfBackendCode, lcOfFrontendCode, lineStopRisk, livePlantsCount} = this.state;
        return <ApplicationConsumer> 
            {
                value => {
                    const {dispatch} = value;
                    return (
                        <div className = "col-md-8 mb-4">
            
                            <button onClick={this.changeVisibility} className = "btn btn-dark btn-black mb-1 ">{visible ? "Hide" : "Show"}</button>
                            <Animation pose = {visible ? "visible" : "hidden"}>
                            <div className="card"> 
                                <div className="card-header">   
                                <h4>Add Application Form </h4>
                                </div>
                            </div>
                            <div className="card-body">
                                <form onSubmit = {this.addApplication.bind(this,dispatch)}>
                                    <div className="form-group">  
                                    <label htmlFor="shortCode">Short Code</label>
                                    <input
                                    type = "text"
                                    name = "shortCode"
                                    id   = "id"
                                    placeholder = "Enter shortCode"
                                    className = "form-control"
                                    value = {shortCode}
                                    onChange = {this.changeInput}
                                    />
                                    </div>
            
                                    <div className="form-group">  
                                    <label htmlFor="releaseDate">releaseDate</label>
                                    <input
                                    type = "text"
                                    name = "releaseDate"
                                    id   = "releaseDate"
                                    placeholder = "Enter releaseDate"
                                    className = "form-control"
                                    value = {releaseDate}
                                    onChange = {this.changeInput}
                                    />
                                    </div>
            
                                    <div className="form-group">  
                                    <label htmlFor="responsible">responsible</label>
                                    <input
                                    type = "text"
                                    name = "responsible"
                                    id   = "responsible"
                                    placeholder = "Enter responsible"
                                    className = "form-control"
                                    value = {responsible}
                                    onChange = {this.changeInput}
                                    />
                                    </div>
                                    <button className="btn btn-danger btn-block" type = "submit"> Add Application </button>
            
                                </form>
                            </div> </Animation>

                            <Applications/>
                        </div>
                    )
                }
            }
        </ApplicationConsumer>
    }
}
export default AddApplication;
