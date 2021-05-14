//import logo from './logo.svg';
import './App.scss';

import "./assets/vendors/iconfonts/mdi/css/materialdesignicons.css"
import "./assets/vendors/css/vendor.addons.css"
import "./assets/css/demo_1/style.css"
import "./assets/css/shared/style.css"

import Navbar from "./components/Navbar/Navbar.js";
import Sidebar from "./components/Sidebar/Sidebar.js";
import AddApplication from './components/AddApplication';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import Home from './components/Home';


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
            <Route path="/addApp" component={AddApplication} />
            </Switch>
          </div>
        </div>

        {/*
      <script src="../assets/vendors/js/core.js"></script>
      <script src="../assets/vendors/apexcharts/apexcharts.min.js"></script>
      <script src="../assets/vendors/chartjs/Chart.min.js"></script>
      <script src="../assets/js/charts/chartjs.addon.js"></script>
      <script src="../assets/js/template.js"></script>
      <script src="../assets/js/dashboard.js"></script>  */}
      </body>
    </Router>
  );
}

export default App;
