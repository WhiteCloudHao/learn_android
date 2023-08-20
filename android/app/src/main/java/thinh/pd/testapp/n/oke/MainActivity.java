package thinh.pd.testapp.n.oke;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Logger;
import com.getcapacitor.PluginLoadException;
import com.getcapacitor.PluginManager;

import java.util.Calendar;

public class MainActivity extends BridgeActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setAlarm();
//    }
//    private void setAlarm() {
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//        // Tạo một Intent để kích hoạt khi đến thời gian đặt lịch
//        Intent intent = new Intent(this, MyBroadcastReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
//        long repeatInterval = 60 * 1000; // Mỗi phút
//        long triggerTime = System.currentTimeMillis() + repeatInterval;
//        // Lấy thời gian hiện tại và thêm 5 giây
////        Calendar calendar = Calendar.getInstance();
////        calendar.add(Calendar.SECOND, 5);
//        // Lấy thời gian hiện tại
////        Calendar calendar = Calendar.getInstance();
////
////// Đặt thời gian mong muốn
////        calendar.set(Calendar.YEAR, 2023);
////        calendar.set(Calendar.MONTH, Calendar.JUNE); // Lưu ý: Trong Calendar, tháng bắt đầu từ 0 (tháng 0 là tháng 1)
////        calendar.set(Calendar.DAY_OF_MONTH, 1);
////        calendar.set(Calendar.HOUR_OF_DAY, 15);
////        calendar.set(Calendar.MINUTE, 3);
////        calendar.set(Calendar.SECOND, 0);
//
//        // Đặt lịch với AlarmManager
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime, repeatInterval, pendingIntent);
//    }
}
