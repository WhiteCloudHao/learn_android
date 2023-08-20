import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
      token: null
    },
    mutations: {
      setToken(state, token) {
        console.log("aaaa set", token)
        state.token = token;
      }
    },
    getters: {
      getToken: state => state.token
    }
  });
  
export default store;