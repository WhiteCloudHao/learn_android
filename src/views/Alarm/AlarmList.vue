<template>
    <div class="alarm_list">
        <button @click="() => {$router.push('/alarm/alarm-add')}">Add Alarm</button>
        <ul>
          <li v-for="alarm in alarms" :key="alarm.id">
            {{ alarm.id }}, {{ alarm.title }}, {{ alarm.description }}, {{ alarm.date }}, {{ alarm.time }},{{ alarm.repeat }}
            <button @click="redirectAlarmEdit(alarm.id)">Edit</button>
            <button @click="deleteAlarm(alarm.id)">Delete</button>
          </li>
        </ul>
    </div>
</template>
  
<script>
    import { liveQuery } from "dexie";
    import { useObservable } from "@vueuse/rxjs";
    import { db } from "@/database/AlarmDb";
import { LocalNotifications } from '@capacitor/local-notifications';
  
    export default {
      name: "AlarmList",
      data() {
        return {
          db,
          alarms: useObservable(
            liveQuery(() => db.alarms.toArray())
          ),
        };
      },
      methods: {
        deleteAlarm(id) {
          // delete noti
          this.db.alarms.delete(id)
          console.log("ok", id)
          const options = {
            notifications: [
              { id: id }, // Thay 'notification_id_1' bằng ID của thông báo cần hủy
            // Thêm các thông báo khác nếu cần
            ],
          };
          LocalNotifications.cancel(options)
          // delete db noti
        },
        redirectAlarmEdit(id) {
          this.$router.push({path: '/alarm/alarm-edit', query: {id,}})
        },
      }
    };
</script>