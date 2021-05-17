import axios from 'axios';

const ISSUES_REST_API = 'http://localhost:8080/deneme/issues';

class IssueService{

    getIssues(){
        return axios.get(ISSUES_REST_API);
    }



}
export default new IssueService();