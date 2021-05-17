import React, { Component } from 'react'
import PropTypes from 'prop-types';
import IssueConsumer from '../IssueContext.js';
import IssueService from '../services/IssueService.js';

class IssueComponent extends Component {
    componentDidMount() {
        IssueService.getIssues().then((response) => {

            this.setState({ issues: response.data });

        });
    }
    impactLevelToBgColor(impactID) {
        switch (impactID) {
            case 4:
                return "#cc0000";
            case 3:
                return "#ffa500";
            case 2:
                return "#ffff00";
            case 1:
                return "#049c0c";
            default:
                return "#FFFFFF";
        }
    }
    impactLevelToTextColor(impactID) {
        switch (impactID) {
            case 4:
                return "#FFFFFF";
            case 3:
                return "#000000";
            case 2:
                return "#000000";
            default:
                return "#FFFFFF";
        }
    }

    render() {
        const { applicationID, plantID, prodID, jobID, jobName } = this.props;
        const { eren } = "deneme123";
        const dizi = [];
        return (
            <IssueConsumer>
                {
                    value => {
                        const { issues } = value;
                        var match = false;
                        var jWissueImpactID;
                        return (
                            issues.map(issue => {
                                return (
                                    issue.plantApp == null ? // İçerisinde veri bulundurmayan bir Issue oluşturmuş olabilir.O yüzden bu condition var.
                                        null
                                        :
                                        applicationID == issue.plantApp.application.applicationID ?
                                            plantID == issue.plantApp.plant.plantID ?
                                                issue.issueJobType.map(jWissue => {
                                                    return (
                                                        jobID == jWissue.jobID ?
                                                            (jWissueImpactID=jWissue.impact.impactID,
                                                            match = true)
                                                            : null
                                                    )
                                                })
                                                : null
                                            : null
                                )
                            }
                            )
                        ),
                            match == false ?
                                <div className="job" style={{ backgroundColor: "#049c0c" }}>
                                    <p className="text-center" style={{ color: "#FFFFFF" }}> {jobName}</p>
                                </div>
                                :
                                <div className="job" style={{ backgroundColor: this.impactLevelToBgColor(jWissueImpactID)}}>
                                    <p className="text-center" style={{ color: this.impactLevelToTextColor(jWissueImpactID) }}> {jobName} </p>
                                </div>
                    }
                }
            </IssueConsumer>
        )
    }
}
export default IssueComponent;