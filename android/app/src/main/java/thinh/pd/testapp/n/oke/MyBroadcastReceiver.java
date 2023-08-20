package thinh.pd.testapp.n.oke;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
        // Xử lý sự kiện khi đến thời gian đặt lịch
        String a = "thinhpd";
        System.out.println(a);

        // Tạo đối tượng NotificationManager
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "my_channel_id";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Tạo một kênh thông báo
            // Định danh kênh thông báo (cần được định nghĩa trước)
            CharSequence channelName = "My Channel"; // Tên kênh thông báo
            int importance = NotificationManager.IMPORTANCE_DEFAULT; // Mức độ ưu tiên của kênh

            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            // Đặt các cài đặt khác cho kênh thông báo (âm thanh, đèn thông báo, ...)
            // ...

            // Thêm kênh thông báo vào NotificationManager
            notificationManager.createNotificationChannel(channel);
        }
// Thiết lập thông báo
         // Định danh kênh thông báo (cần được định nghĩa trước)
        String title = "Thông báo" + getTimeString(); // Tiêu đề thông báo
        String message = "Lịch đã đến!"; // Nội dung thông báo

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_stat_access_time) // Icon nhỏ của thông báo
                .setContentTitle(title) // Tiêu đề của thông báo
                .setContentText(message) // Nội dung của thông báo
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); // Mức độ ưu tiên của thông báo
// Hiển thị thông báo
        int notificationId = (int)(Math.random() * 100); // ID duy nhất cho thông báo
        notificationManager.notify(notificationId, builder.build());
    }
    private String getTimeString() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }
}
