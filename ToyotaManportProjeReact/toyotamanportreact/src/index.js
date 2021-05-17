import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { ApplicationProvider } from './context';
import { PlantAppProvider } from './PlantAppContext';
import { IssueProvider } from './IssueContext';

ReactDOM.render(
  <IssueProvider>
    <PlantAppProvider>
      <ApplicationProvider>
        <App />
      </ApplicationProvider>
    </PlantAppProvider>
  </IssueProvider>
  ,
  document.getElementById('root')
);
reportWebVitals();
