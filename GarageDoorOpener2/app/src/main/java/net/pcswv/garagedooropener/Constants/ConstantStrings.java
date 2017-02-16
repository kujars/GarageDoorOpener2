package net.pcswv.garagedooropener.Constants;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

/**
 * Created by droby on 2/15/2017.
 */

public class ConstantStrings extends Context {
    TextView statmsg;
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    public static final String starting = "Connecting....";
    public static final String connected = "Connected, Awaiting Command";
    public static final String dc = "Disconnected";
    public static final String err ="Unable To Connect";
    public static final String msg1 = "Please Go Setup The Network Options";
}
