//import logo from './logo.svg';
import './App.scss';

import "./assets/vendors/iconfonts/mdi/css/materialdesignicons.css"
import "./assets/vendors/css/vendor.addons.css"
import "./assets/css/demo_1/style.css"
import "./assets/css/shared/style.css"

import Navbar from "./components/Navbar/Navbar.js";
import Sidebar from "./components/Sidebar/Sidebar.js";
import denemeAddApp from './components/denemeAddApp';
import IssuesManagementComponent from './components/IssuesManagementComponent.js';
import PlantManagementComponent from './components/PlantManagementComponent.js';
import AddApplicationComponent from './components/AddApplicationComponent.js'

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import Home from './components/Home';
import "../src/"
import ManagementComponent from './components/ManagementComponent';


function App() {
  return (
    <Router>
      <body className="header-fixed">
        <Navbar />
        <div className="page-body">
          <Sidebar />
          <div className="page-content-wrapper px-0">
            <Switch>
            <Route path="/home" exact component={Home} />
            <Route path="/dashboard" component={Dashboard} />
            <Route path="/addApp" component={denemeAddApp} />
            <Route path="/management" component={ManagementComponent} />
            <Route path="/issuesManagement" component={IssuesManagementComponent} />

            <Route path="/addApplication" component={AddApplicationComponent} />
            <Route path="/plantManagement" component={PlantManagementComponent} />

            </Switch>
          </div>
        </div>

        
      <script src="../src/assets/vendors/js/core.js"></script>
      <script src="../src/assets/vendors/apexcharts/apexcharts.min.js"></script>
      <script src="../src/assets/vendors/chartjs/Chart.min.js"></script>
      <script src="../src/assets/js/charts/chartjs.addon.js"></script>
      <script src="../src/assets/js/template.js"></script>
      <script src="../src/assets/js/dashboard.js"></script>  
      </body>
    </Router>
  );
}

export default App;
