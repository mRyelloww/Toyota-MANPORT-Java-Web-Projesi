import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { ApplicationProvider } from './context';
import { PlantAppProvider } from './PlantAppContext';
import { IssueProvider } from './IssueContext';
import { CountryProvider } from './CountryContext';

ReactDOM.render(
  <CountryProvider>
    <IssueProvider>
      <PlantAppProvider>
        <ApplicationProvider>
          <App />
        </ApplicationProvider>
      </PlantAppProvider>
    </IssueProvider>
  </CountryProvider>
  ,
  document.getElementById('root')
);
reportWebVitals();
