import React, { Component } from 'react'
import IssueConsumer from '../IssueContext.js';
import axios from 'axios';
import Moment from 'moment';

class LastIssuesComponent extends Component {

    state = {
        sortedIssues: []
    }
    componentDidMount = async () => {
        const response = await axios.get("http://localhost:8080/deneme/siraliIssues")

        this.setState({
            sortedIssues: response.data
        })

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
    render() {
        Moment.locale('en')
        return (
            <div className="px-5 py-2" style={{ backgroundColor: "#D1D1CD", height: "100px" }}>
                <h6> Last Issues: </h6>
                {this.state.sortedIssues.map(dnm => {
                    var prodName;
                    var impactLvL = 1;
                    if (dnm.plantApp != null) {
                        dnm.plantApp.plant.productions.map(prod => {
                            prod.jobs.map(job => {
                                dnm.issueJobType.map(issueJob => {
                                    if (job.jobID === issueJob.jobID) {
                                        prodName = prod.productionName;
                                        impactLvL = issueJob.impact.impactID;
                                    }
                                })
                            })
                        })

                        //console.log("impactLvL:",impactLvL);
                        return (
                            <p> {Moment(dnm.date).format('D MM YYYY H:m')} --&gt; <b style={{ color: this.impactaGoreRenkAl(impactLvL) }}>{dnm.plantApp.application.shortCode} - {dnm.plantApp.plant.country.countryName} - {prodName} </b> : {dnm.issueJobType.map(job => { return (job.jobName) })} </p>
                        )
                    }
                })}
            </div>
        )
    }
}
export default LastIssuesComponent;
