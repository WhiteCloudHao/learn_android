<template>
    <div class="add_alarm">
        <button @click="() => {$router.push('/alarm/alarm-list')}">Alarm list</button>
        <div class="add_alarm--input">
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
        </div>
    </div>
</template>

<script>
// import {
//   PushNotifications,
// } from '@capacitor/push-notifications';
import { LocalNotifications } from '@capacitor/local-notifications'
import { db } from "@/database/AlarmDb";
export default {
    name: 'AlarmAdd',
    data() 
    {
    return {
      alarmInfor: {
        title: '',
        description: '',
        date: '',
        time: '',
        repeat: ''
      },
      alarmId: null,
    }
  },
  methods: {
    // push noti method 
    // ngOnInit() {
    //   PushNotifications.requestPermissions().then(result => {
    //     if (result.receive === 'granted') {
    //       // Register with Apple / Google to receive push via APNS/FCM
    //       PushNotifications.register();
    //     } else {
    //       // Show some error
    //     }
    //   });

    //   PushNotifications.addListener('registration', (token) => {
    //     alert('Push registration success, token: ' + token.value);
    //     this.test = token.value
    //   });

    //   PushNotifications.addListener('registrationError', (error) => {
    //     alert('Error on registration: ' + JSON.stringify(error));
    //   });

    //   PushNotifications.addListener(
    //     'pushNotificationReceived',
    //     async (notification) => {
    //       alert('Push received: ' + JSON.stringify(notification));
    //     },
    //   );

    //   PushNotifications.addListener(
    //     'pushNotificationActionPerformed',
    //     (notification) => {
    //       alert('Push action performed: ' + JSON.stringify(notification));
    //     },
    //   );
    // },
    handleFieldSetAlarm() {
      let submitAlarmInfor = {};
      submitAlarmInfor.title= this.alarmInfor.title
      submitAlarmInfor.description= this.alarmInfor.description
      submitAlarmInfor.date   = this.alarmInfor.date.replace(/\//g, "-");
      submitAlarmInfor.time= this.alarmInfor.time
      submitAlarmInfor.timeSetAlarm = new Date(submitAlarmInfor.date+ "T"+submitAlarmInfor.time+":00") 
      submitAlarmInfor.repeat = this.alarmInfor.repeat
      console.log(submitAlarmInfor)
      return submitAlarmInfor;
    },
    async scheduleNotification() {
      try {
        // Add the new friend!
        const id = await db.alarms.update(+this.alarmId,{
          title: this.alarmInfor.title,
          description: this.alarmInfor.description,
          date: this.alarmInfor.date,
          time: this.alarmInfor.time,
          repeat: this.alarmInfor.repeat,
        })
        const options = {
            notifications: [
              { id: +this.alarmId }, // Thay 'notification_id_1' bằng ID của thông báo cần hủy
            // Thêm các thông báo khác nếu cần
            ],
          };
          LocalNotifications.cancel(options)
        let submitAlarmInfor = this.handleFieldSetAlarm()
      LocalNotifications.schedule({
        notifications: [
          {
            id: id,
            channelId: 'AlarmNoti', // If you are using channels
            title: submitAlarmInfor.title,
            body: submitAlarmInfor.description,
            schedule: {
              at: submitAlarmInfor.timeSetAlarm,
              allowWhileIdle: true,
              repeats: submitAlarmInfor.repeat? true: false,
              every: submitAlarmInfor.repeat
            },
            smallIcon: "ic_stat_access_time",
            extra: {
              // Any random data you want to add
            },
          },
        ],
      })

        console.log("hahah", id)
      } catch (error) {
         console.log('error', error)
      }
                  
    },
    creatChanelAlarm() {
      LocalNotifications.createChannel({
        id: 'AlarmNoti',
        name: 'AlarmNoti',
        description: 'set Alarm for app',
        importance: 4
      })
      LocalNotifications.removeAllListeners()

      LocalNotifications.addListener('localNotificationActionPerformed', (notification) => {
        if (notification.actionId === 'tap') {
          // console.log("hahah")
        }
      })
    },
    async initData() {
      this.alarmId = this.$route.query.id
      let alarmInfor = await db.alarms.get(+this.alarmId)
      console.log('dd', alarmInfor)
      this.alarmInfor.title = alarmInfor.title
      this.alarmInfor.description = alarmInfor.description
      this.alarmInfor.date = alarmInfor.date
      this.alarmInfor.time = alarmInfor.time
      this.alarmInfor.repeat = alarmInfor.repeat
    },
  },
  async mounted() {
    // this.getApiData()
    // alert("jaa")
    // await this.getApiDataCheckSpring()
    // this.ngOnInit();
    this.creatChanelAlarm()
    this.initData()

    // check call api 
  }
}
</script>

<style>
.add_alarm--input {
  display: flex;
  flex-direction: column;
}

</style>