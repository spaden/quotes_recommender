import axios from "axios";

const interceptor = axios.create({
    baseURL: 'http://localhost:8000'
})

export default interceptor 