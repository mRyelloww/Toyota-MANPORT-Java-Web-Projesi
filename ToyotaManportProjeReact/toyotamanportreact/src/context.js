import React, { Component } from 'react'
import axios from "axios";

const ApplicationContext = React.createContext();
// Provider , Consumer vermiş olacak bize 
const reducer = (state,action) => {    
    
  switch(action.type){
    case "DELETE_APPLICATION":
      return{
        ...state,
        applications: state.applications.filter(application => action.payload !== application.applicationID)
      }
    case "ADD_APPLICATION":
      return{
        ...state,
        applications : [...state.applications , action.payload]
      }
    default:
      return state
  }
  
}

export class ApplicationProvider extends Component {
    state = {
        applications: [/*
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
        dispatch : action => {
          this.setState(state => reducer(state,action))
        }
    }
    
    componentDidMount = async () => {
        const response = await axios.get("http://localhost:8080/deneme/application")       
        console.log(response);
        
        this.setState({
            applications: response.data
        })
        
    }
    render() {
        return (
            <ApplicationContext.Provider value = {this.state}> 
            {this.props.children}
            </ApplicationContext.Provider>
        )
    }
}
const ApplicationConsumer = ApplicationContext.Consumer;

export default ApplicationConsumer; // export default mantığı context.js yi diğer js lerdede kullanabilmemize (erişebilmemize) olanak sağlar.