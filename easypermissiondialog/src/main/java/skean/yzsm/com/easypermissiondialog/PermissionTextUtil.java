package skean.yzsm.com.easypermissiondialog;

import android.Manifest;

import java.util.Locale;

/**
 * 权限字符工具
 */
public class PermissionTextUtil {

    public static String getDescription(String permession) {
        String desc = null;
        switch (permession) {
            case Manifest.permission.READ_CALENDAR:
                desc = isChinese() ? "读取日程" : "Read Calendar";
                break;
            case Manifest.permission.WRITE_CALENDAR:
                desc = isChinese() ? "写入日程" : "Write Calendar";
                break;
            case Manifest.permission.CAMERA:
                desc = isChinese() ? "摄像头" : "Camera";
                break;
            case Manifest.permission.READ_CONTACTS:
                desc = isChinese() ? "读取联系人" : "Read Contacts";
                break;
            case Manifest.permission.WRITE_CONTACTS:
                desc = isChinese() ? "写入联系人" : "Write Contacts";
                break;
            case Manifest.permission.GET_ACCOUNTS:
                desc = isChinese() ? "获取账号信息" : "Get Accounts";
                break;
            case Manifest.permission.ACCESS_FINE_LOCATION:
                desc = isChinese() ? "模糊定位" : "Access Fine Location";
                break;
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                desc = isChinese() ? "精确定位" : "Access Coarse Location";
                break;
            case Manifest.permission.ACCESS_BACKGROUND_LOCATION:
                desc = isChinese() ? "后台定位" : "Access Background Location";
                break;
            case Manifest.permission.RECORD_AUDIO:
                desc = isChinese() ? "录音" : "Record Audio";
                break;
            case Manifest.permission.READ_PHONE_STATE:
                desc = isChinese() ? "读取手机信息" : "Read Phone State";
                break;
            case Manifest.permission.CALL_PHONE:
                desc = isChinese() ? "拨打电话" : "Call Phone";
                break;
            case Manifest.permission.READ_CALL_LOG:
                desc = isChinese() ? "读取通话记录" : "Read Call Log";
                break;
            case Manifest.permission.WRITE_CALL_LOG:
                desc = isChinese() ? "写入通话记录" : "Write Call Log";
                break;
            case Manifest.permission.ADD_VOICEMAIL:
                desc = isChinese() ? "添加语音邮件" : "Add Voice Mail";
                break;
            case Manifest.permission.USE_SIP:
                desc = isChinese() ? "使用SIP" : "Use SIP";
                break;
            case Manifest.permission.PROCESS_OUTGOING_CALLS:
                desc = isChinese() ? "处理去电" : "Process Outgoing Calls";
                break;
            case Manifest.permission.BODY_SENSORS:
                desc = isChinese() ? "身体传感器" : "Body Sensors";
                break;
            case Manifest.permission.SEND_SMS:
                desc = isChinese() ? "发送短信" : "Send SMS";
                break;
            case Manifest.permission.RECEIVE_SMS:
                desc = isChinese() ? "接收短信" : "Receive SMS";
                break;
            case Manifest.permission.READ_SMS:
                desc = isChinese() ? "读取短信" : "Read SMS";
                break;
            case Manifest.permission.RECEIVE_WAP_PUSH:
                desc = isChinese() ? "接收WAP推送" : "Receive WAP Push";
                break;
            case Manifest.permission.RECEIVE_MMS:
                desc = isChinese() ? "接收彩信" : "Receive MMS";
                break;
            case Manifest.permission.READ_EXTERNAL_STORAGE:
                desc = isChinese() ? "读取外部存储" : "Read External Storage";
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                desc = isChinese() ? "写入外部存储" : "Write External Storage";
                break;
        }
        return desc;
    }

    public static boolean isChinese() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals("zh") && //
                locale.getCountry().equals("CN");
    }

}
