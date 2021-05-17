import React, { Component } from 'react'
import axios from "axios";

const PlantAppContext = React.createContext();
// Provider , Consumer vermiş olacak bize 

export class PlantAppProvider extends Component {
    state = {
        plantapps: [/*
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
        const response = await axios.get("http://localhost:8080/deneme/plantapp")       
        console.log(response);
        
        this.setState({
            plantapps: response.data
        })
        
    }
    render() {
        return (
            <PlantAppContext.Provider value = {this.state}> 
            {this.props.children}
            </PlantAppContext.Provider>
        )
    }
}
const PlantAppConsumer = PlantAppContext.Consumer;

export default PlantAppConsumer; // export default mantığı PlantApp.js yi diğer js lerdede kullanabilmemize (erişebilmemize) olanak sağlar.