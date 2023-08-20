import axios from "axios";
import store from '../store';

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    // withCredentials: true,
    mode: 'cors',
    timeout: 1000 * 3600, // request timeout
    headers: {
        // "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "http://localhost:8081", // Thay * bằng domain của bạn
        "Access-Control-Allow-Headers": "Content-Type, Authorization",
        "Access-Control-Allow-Methods": "GET, POST, OPTIONS, PUT, DELETE"
      },
      credentials: "include",
      xsrfCookieName: "XSRF-TOKEN"
});

service.interceptors.request.use(
    (config) => {
      if (config.headers["Content-Type"] != "multipart/form-data") {
        config.headers["Content-Type"] = "application/json; charset=utf-8";
      }
      if(store.state.token !== null) {
        config.headers["Authorization"] = store.state.token;
      }
    //   config.headers["Access-Control-Allow-Origin"] ='http://localhost:8081'
    //   config.headers["Access-Control-Allow-Credentials"] = true
      return config;
    },
    (error) => {
      console.log(error); // for debug
      return Promise.reject(error);
    }
);

export default service;