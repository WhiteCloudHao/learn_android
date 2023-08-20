<template>
  <div id="app">
  
    <!-- <img alt="Vue logo" src="./assets/logo.png">   -->
      <!-- <router-link to="/home">Home</router-link> -->
        
    <!-- <HelloWorld msg="Welcome to Your Vue.js App thinhpd www"/>
     -->
     <!-- <home-page /> -->
    <!-- <h3>af thinh a111 </h3>
    <h3>u toi day</h3>
    <h1>eee</h1>
    
    <button @click="getCustomer()"> customer </button>
    <h2>{{ test }}</h2>
    <h1>{{ token }}</h1> -->
    <!-- form custom for beauty -->
       <!-- <input type="text" placeholder="userName" id="userName"/>
       <input type="text" placeholder="Password" id="password"/>
       <button type="submit" @click="submit"> Đăng nhập</button> -->
    <!--end form -->
    <!-- <div class="set_alarm">

      <input type="text" placeholder="title" v-model="alarmInfor.title"/>
      <input type="text" placeholder="description" v-model="alarmInfor.description"/>
      <input type="date" placeholder="date" v-model="alarmInfor.date"/>
      <input type="time" placeholder="time" v-model="alarmInfor.time"/>
      <select id="repeat" name="repeat" v-model="alarmInfor.repeat">
        <option value="">No repeat</option>
        <option value="second">every second</option>
        <option value="minute">every minute</option>
        <option value="hour">every hour</option>
        <option value="day">every day</option>
        <option value="week">every week</option>
        <option value="two-weeks">every two weeks</option>
        <option value="month">every month</option>
        <option value="year">every year</option>
      </select>
      <button @click="scheduleNotification">Set Alarm</button>
      </div> -->
    <router-view />
  </div>
</template>

<script>
// import store from './store';
// import request from './utils/request'
// import {
//   PushNotifications,
// } from '@capacitor/push-notifications';
// import { LocalNotifications } from '@capacitor/local-notifications'
// import { db } from './database/AlarmDb';



export default {
  name: 'App',
  components: {
    // HelloWorld,
    // HomePage
  },
  data() 
    {
    return {
      token: '',
      test: '',
      alarmInfor: {
        title: '',
        description: '',
        date: '',
        time: '',
        repeat: ''
      },
    }
  },
  // methods: {
  //   // form custom 
  //       submit() {
  //         let userName = document.getElementById('userName').value
  //         let password = document.getElementById('password').value
  //         // alert(userName)
  //         this.getApiDataUsingAxios({userName: userName, password: password})
  //       },
  //   // end form
  //   async getApiDataCheckSpring () {
  //     alert("aho")
  //       const data = {
  //           title: "Minh",
  //       content: "Thuong",
  //       shortDescription: "thuong.nmstudy.hust@gmail.com",
  //       categoryCode: "1234",
  //       thumbnail: "1234"
  //     }
  //     const response = await fetch("http://localhost:8082/new",
  //       {
  //         method: "POST",
  //         mode: "cors",
  //         headers: {
  //           "Content-Type": "application/json",
  //         },
  //         body: JSON.stringify(data),
  //       }
  //     ).then((response) => response.json())
  //       .then(data => console.log(data))
  //       .catch(error => console.error(error));
  //     console.log(response)
  //     // setUsers(response);
  //   },

  //   async getApiDataUsingAxios(dataProp) {
  //     const data = new FormData()
  //     data.append('user_id', dataProp.userName);
  //     data.append('user_pwd', dataProp.password);
  //     const response = await request.post('/login/login', null, {
  //       params: {
  //         user_id: dataProp.userName,
  //         user_pwd: dataProp.password
  //       }
  //     })
  //     alert(response.data.data.token);
  //     this.token = response.data.data.token
  //     this.test = "okle"
  //     store.commit('setToken', this.token);
  //   },

  //   async getApiData() {
  //     const data = new FormData()
  //     data.append('user_id', 'tester');
  //     data.append('user_pwd', 'testerA@1');
  //     const response = await fetch("http://192.168.0.75:8099/api/v1/login/login",
  //       {
  //         method: "POST",
  //         mode: "cors",
  //         body: data
  //       }
  //     )
  //       .then((response) => response.json())
  //     this.token = response.data.token
  //     this.test = "okle"
  //     store.commit('setToken', this.token);
  //   },
  //   async getCustomer() {
  //     const params = {
  //       pageSize: 10,
  //       currentPage: 1
  //     }
  //     const response = await fetch(`http://192.168.0.75:8099/api/v1/customers?pageSize=${params.pageSize}&currentPage=${params.currentPage}&sort=DESC`, {
  //       method: 'GET',
  //       headers: {
  //         'Authorization': 'Bearer ' + store.getters.getToken
  //       }
  //     }).then((response) => response.json())
  //     alert(response.data_list[0].num)
  //   },

  //   // push noti method 
  //   ngOnInit() {
  //     // Request permission to use push notifications
  //     // iOS will prompt user and return if they granted permission or not
  //     // Android will just grant without prompting
  //     PushNotifications.requestPermissions().then(result => {
  //       if (result.receive === 'granted') {
  //         // Register with Apple / Google to receive push via APNS/FCM
  //         PushNotifications.register();
  //       } else {
  //         // Show some error
  //       }
  //     });

  //     PushNotifications.addListener('registration', (token) => {
  //       alert('Push registration success, token: ' + token.value);
  //       this.test = token.value
  //     });

  //     PushNotifications.addListener('registrationError', (error) => {
  //       alert('Error on registration: ' + JSON.stringify(error));
  //     });

  //     PushNotifications.addListener(
  //       'pushNotificationReceived',
  //       async (notification) => {
  //         alert('Push received: ' + JSON.stringify(notification));
  //       },
  //     );

  //     PushNotifications.addListener(
  //       'pushNotificationActionPerformed',
  //       (notification) => {
  //         alert('Push action performed: ' + JSON.stringify(notification));
  //       },
  //     );
  //   },
  //   handleFieldSetAlarm() {
  //     let submitAlarmInfor = {};
  //     submitAlarmInfor.title= this.alarmInfor.title
  //     submitAlarmInfor.description= this.alarmInfor.description
  //     submitAlarmInfor.date   = this.alarmInfor.date.replace(/\//g, "-");
  //     submitAlarmInfor.time= this.alarmInfor.time
  //     submitAlarmInfor.timeSetAlarm = new Date(submitAlarmInfor.date+ "T"+submitAlarmInfor.time+":00") 
  //     submitAlarmInfor.repeat = this.alarmInfor.repeat
  //     console.log(submitAlarmInfor)
  //     return submitAlarmInfor;
  //   },
  //   async scheduleNotification() {
  //     try {
  //       // Add the new friend!
  //       const id = await db.alarms.add({
  //         title: this.alarmInfor.title,
  //         description: this.alarmInfor.description,
  //         date: this.alarmInfor.date,
  //         time: this.alarmInfor.time,
  //         repeat: this.alarmInfor.repeat,
  //       });

  //       console.log("hahah", id)
  //     } catch (error) {
  //        console.log('error', error)
  //     }
  //     let submitAlarmInfor = this.handleFieldSetAlarm()
  //     LocalNotifications.schedule({
  //       notifications: [
  //         {
  //           id: Math.floor(Math.random() * 100) + 1,
  //           channelId: 'reminders', // If you are using channels
  //           title: submitAlarmInfor.title,
  //           body: submitAlarmInfor.description,
  //           schedule: {
  //             at: submitAlarmInfor.timeSetAlarm,
  //             allowWhileIdle: true,
  //             repeats: submitAlarmInfor.repeat? true: false,
  //             every: submitAlarmInfor.repeat
  //           },
  //           smallIcon: "ic_stat_access_time",
  //           extra: {
  //             // Any random data you want to add
  //           },
  //         },
  //       ],
  //     })
  //     LocalNotifications.createChannel({
  //       id: 'reminders',
  //       name: 'Reminders',
  //       description: 'Reminders you set within App',
  //       importance: 4
  //     })
  //     LocalNotifications.removeAllListeners()

  //     LocalNotifications.addListener('localNotificationActionPerformed', (notification) => {
  //       if (notification.actionId === 'tap') {
  //         // console.log("hahah")
  //       }
  //     })
      
  //   },
  // },
  async mounted() {
    // this.getApiData()
    // alert("jaa")
    // await this.getApiDataCheckSpring()
    // this.ngOnInit();
    // check call api 
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.set_alarm {
  display: flex;
  flex-direction: column;
}



</style>
