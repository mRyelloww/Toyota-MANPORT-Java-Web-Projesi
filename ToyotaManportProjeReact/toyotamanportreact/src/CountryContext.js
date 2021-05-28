import React, { Component } from 'react'
import axios from "axios";

const CountryContext = React.createContext();
// Provider , Consumer vermiş olacak bize 

export class CountryProvider extends Component {
    state = {
        countries: [
        ],
    }
    
    componentDidMount = async () => {
        const response = await axios.get("http://localhost:8080/deneme/country")       
        //console.log(response);
        
        this.setState({
            countries: response.data
        })
    }
    changeCountryName = () =>{   
        this.setState({
            
        })
    }
    render() {
        return (
            <CountryContext.Provider value = {this.state}> 
            {this.props.children}
            </CountryContext.Provider>
        )
    }
}
const CountryConsumer = CountryContext.Consumer;

export default CountryConsumer; // export default mantığı PlantApp.js yi diğer js lerdede kullanabilmemize (erişebilmemize) olanak sağlar.