import axios from 'axios';

const APPLICATONS_REST_API = 'http://localhost:8080/deneme/application';


class ApplicationService{

    getApplications(){
        return axios.get(APPLICATONS_REST_API);
    }


}
export default new ApplicationService();