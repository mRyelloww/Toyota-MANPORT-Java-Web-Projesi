import React, { Component } from 'react'
import axios from 'axios';
import CountryConsumer from '../CountryContext';


class Home extends Component {
    updateData(country){
        const data ={
            "countryID":country.countryID,
            "countryName":country.countryName,
            "appCount":24
        }
        axios.put("http://localhost:8080/deneme/country/1",data)

    }
    render() {
        return (
            <CountryConsumer>{
                value => {
                    const { countries } = value;
                    //this.updateData(2);
                    return (
                        
                        countries.map((country,index) => {
                            //country.countryName = "asd123";
                            if(index == 2){
                                this.updateData(country)
                            }
                            return (
                                <div>
                                    <p> {country.countryName} </p>
                                </div>
                            )
                        })
                    )
                }
            }
            </CountryConsumer>
        )
    }
}
export default Home;
