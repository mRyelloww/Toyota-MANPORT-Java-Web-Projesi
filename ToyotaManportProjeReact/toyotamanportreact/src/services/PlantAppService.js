import axios from 'axios';

const PLANTAPPS_REST_API = 'http://localhost:8080/deneme/plantapp';

class PlantAppService{

    getPlantApps(){
        return axios.get(PLANTAPPS_REST_API);
    }



}
export default new PlantAppService();