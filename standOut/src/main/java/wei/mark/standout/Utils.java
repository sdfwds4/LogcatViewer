package wei.mark.standout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.provider.Settings;

public class Utils {
	public static boolean isSet(int flags, int flag) {
		return (flags & flag) == flag;
	}

	public static boolean canDrawOverlays(Context context) {
		return VERSION.SDK_INT < VERSION_CODES.M || Settings.canDrawOverlays(context);
	}

	public static Intent getActionManageOverlayPermission(Context context) {
		return new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
	}
}
