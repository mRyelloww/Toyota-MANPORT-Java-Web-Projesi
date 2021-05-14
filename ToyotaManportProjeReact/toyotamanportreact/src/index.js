import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
//import 'bootstrap/dist/css/bootstrap.min.css';
import { ApplicationProvider } from './context';

ReactDOM.render(
  <ApplicationProvider>
    <App />
  </ApplicationProvider>
  ,
  document.getElementById('root')
);
reportWebVitals();
