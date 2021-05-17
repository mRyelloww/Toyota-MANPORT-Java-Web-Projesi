import React, { Component } from 'react'
import axios from "axios";

const IssueContext = React.createContext();
// Provider , Consumer vermiş olacak bize 

export class IssueProvider extends Component {
    state = {
        issues: [/*
          {
            id : "unique-1",
            name : "Mustafa Murat Coşkun",
            salary : "5000",
            department : "Bilişim"
          },
          {
            id : "unique-2",
            name : "Eren Sarı",
            salary : "7",
            department : "RS8"
          }*/
        ],
    }
    
    componentDidMount = async () => {
        const response = await axios.get("http://localhost:8080/deneme/issues")       
        console.log(response);
        
        this.setState({
            issues: response.data
        })
        
    }
    render() {
        return (
            <IssueContext.Provider value = {this.state}> 
            {this.props.children}
            </IssueContext.Provider>
        )
    }
}
const IssueConsumer = IssueContext.Consumer;

export default IssueConsumer; // export default mantığı PlantApp.js yi diğer js lerdede kullanabilmemize (erişebilmemize) olanak sağlar.