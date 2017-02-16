package net.pcswv.garagedooropener.communications;

import net.pcswv.garagedooropener.Constants.ConstantStrings;

import android.widget.TextView;
import net.pcswv.garagedooropener.R;
import net.pcswv.garagedooropener.util.NotificationUpdateRunnable;
/**
 * Created by droby on 2/15/2017.
 */

public class CommunicationService extends ConstantStrings{
    public class CommunicationService extends JSch {
        public static void main(String[] arg) {
            try {
                CommunicationService SSH = new CommunicationService();
                String host = null;
                if (arg.length > 0) {
                    host = arg[0];

                } else {


                }
            }


            try {
                // Connect to Raspberry
                JSch jsch = new JSch();
                Session session = this.getSession();


                if (CommunicationService.ACTION_TOGGLE_IN1.equals(action)) {
                    stopNotification1();
                    client.sendRequest("GET", "/toggleIN1");
                    notificationManager.cancel(NotificationUpdateRunnable.idIN1);
                }

            } catch (Exception e) {
                mHandler.post(new DisplayToast(this, this.getString(R.string.connectionerror)));
            }
        }
    }
}
