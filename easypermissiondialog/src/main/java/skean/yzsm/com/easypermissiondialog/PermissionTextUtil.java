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
                desc = isChinese() ? "读取日程" : "read calendar";
                break;
            case Manifest.permission.WRITE_CALENDAR:
                desc = isChinese() ? "写入日程" : "write calendar";
                break;
            case Manifest.permission.CAMERA:
                desc = isChinese() ? "摄像头" : "camera";
                break;
            case Manifest.permission.READ_CONTACTS:
                desc = isChinese() ? "读取联系人" : "read contacts";
                break;
            case Manifest.permission.WRITE_CONTACTS:
                desc = isChinese() ? "写入联系人" : "write contacts";
                break;
            case Manifest.permission.GET_ACCOUNTS:
                desc = isChinese() ? "获取账号信息" : "get accounts";
                break;
            case Manifest.permission.ACCESS_FINE_LOCATION:
                desc = isChinese() ? "精确定位" : "access fine location";
                break;
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                desc = isChinese() ? "模糊定位" : "access coarse location";
                break;
            case Manifest.permission.ACCESS_BACKGROUND_LOCATION:
                desc = isChinese() ? "后台定位" : "access background location";
                break;
            case Manifest.permission.RECORD_AUDIO:
                desc = isChinese() ? "录音" : "record audio";
                break;
            case Manifest.permission.READ_PHONE_STATE:
                desc = isChinese() ? "读取手机信息" : "read phone state";
                break;
            case Manifest.permission.CALL_PHONE:
                desc = isChinese() ? "拨打电话" : "call phone";
                break;
            case Manifest.permission.READ_CALL_LOG:
                desc = isChinese() ? "读取通话记录" : "read call log";
                break;
            case Manifest.permission.WRITE_CALL_LOG:
                desc = isChinese() ? "写入通话记录" : "write call log";
                break;
            case Manifest.permission.ADD_VOICEMAIL:
                desc = isChinese() ? "添加语音邮件" : "add voice mail";
                break;
            case Manifest.permission.USE_SIP:
                desc = isChinese() ? "使用SIP" : "use sip";
                break;
            case Manifest.permission.PROCESS_OUTGOING_CALLS:
                desc = isChinese() ? "处理去电" : "process outgoing calls";
                break;
            case Manifest.permission.BODY_SENSORS:
                desc = isChinese() ? "身体传感器" : "body sensors";
                break;
            case Manifest.permission.SEND_SMS:
                desc = isChinese() ? "发送短信" : "send sms";
                break;
            case Manifest.permission.RECEIVE_SMS:
                desc = isChinese() ? "接收短信" : "receive sms";
                break;
            case Manifest.permission.READ_SMS:
                desc = isChinese() ? "读取短信" : "read sms";
                break;
            case Manifest.permission.RECEIVE_WAP_PUSH:
                desc = isChinese() ? "接收WAP推送" : "receive wap push";
                break;
            case Manifest.permission.RECEIVE_MMS:
                desc = isChinese() ? "接收彩信" : "receive mms";
                break;
            case Manifest.permission.READ_EXTERNAL_STORAGE:
                desc = isChinese() ? "读取外部存储" : "read external storage";
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                desc = isChinese() ? "写入外部存储" : "write external storage";
                break;
            case Manifest.permission.ACCEPT_HANDOVER:
                desc = isChinese() ? "允许呼叫应用继续在另一个应用中启动的呼叫" : "accept handover";
                break;
            case Manifest.permission.ACCESS_CHECKIN_PROPERTIES:
                desc = isChinese() ? "读取或写入登记check-in数据库" : "access checkin properties";
                break;
            case Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS:
                desc = isChinese() ? "允许应用程序访问额外的位置提供命令" : "access location extra commands";
                break;
            case Manifest.permission.ACCESS_MEDIA_LOCATION:
                desc = isChinese() ? "访问媒体文件的位置信息" : "access media location";
                break;
            case Manifest.permission.ACCESS_NETWORK_STATE:
                desc = isChinese() ? "访问网络状态" : "access network state";
                break;
            case Manifest.permission.ACCESS_NOTIFICATION_POLICY:
                desc = isChinese() ? "访问通知策略" : "access notification policy";
                break;
            case Manifest.permission.ACCESS_WIFI_STATE:
                desc = isChinese() ? "访问WIFI状态" : "access wifi state";
                break;
            case Manifest.permission.ACCOUNT_MANAGER:
                desc = isChinese() ? "管理账号" : "account manager";
                break;
            case Manifest.permission.ACTIVITY_RECOGNITION:
                desc = isChinese() ? "检测用户何时启动或结束Activity" : "activity recognition";
                break;
            case Manifest.permission.ANSWER_PHONE_CALLS:
                desc = isChinese() ? "接听来电" : "answer phone calls";
                break;
            case Manifest.permission.BATTERY_STATS:
                desc = isChinese() ? "获取电池状态" : "battery stats";
                break;
            case Manifest.permission.BIND_ACCESSIBILITY_SERVICE:
                desc = isChinese() ? "绑定到可访问性服务" : "bind accessibility service";
                break;
            case Manifest.permission.BIND_APPWIDGET:
                desc = isChinese() ? "绑定到桌面部件" : "bind appwidget";
                break;
            case Manifest.permission.BIND_AUTOFILL_SERVICE:
                desc = isChinese() ? "绑定到自动填充服务" : "bind autofill service";
                break;
            case Manifest.permission.BIND_CALL_REDIRECTION_SERVICE:
                desc = isChinese() ? "绑定到通话重定向服务" : "bind call redirection service";
                break;
            case Manifest.permission.BIND_CARRIER_MESSAGING_CLIENT_SERVICE:
                desc = isChinese() ? "绑定到运营商信息客户端服务" : "bind carrier messaging client service";
                break;
            case Manifest.permission.BIND_CARRIER_MESSAGING_SERVICE:
                desc = isChinese() ? "绑定到运营商信息服务" : "bind carrier messaging service";
                break;
            case Manifest.permission.BIND_CARRIER_SERVICES:
                desc = isChinese() ? "绑定到运营商" : "bind carrier services";
                break;
            case Manifest.permission.BIND_CHOOSER_TARGET_SERVICE:
                desc = isChinese() ? "绑定到选择对象服务" : "bind chooser target service";
                break;
            case Manifest.permission.BIND_CONDITION_PROVIDER_SERVICE:
                desc = isChinese() ? "绑定到条件提供者服务" : "bind condition provider service";
                break;
            case Manifest.permission.BIND_DEVICE_ADMIN:
                desc = isChinese() ? "绑定到设备管理" : "bind device admin";
                break;
            case Manifest.permission.BIND_DREAM_SERVICE:
                desc = isChinese() ? "绑定到Dream服务" : "bind dream service";
                break;
            case Manifest.permission.BIND_INCALL_SERVICE:
                desc = isChinese() ? "绑定到来电服务" : "bind incall service";
                break;
            case Manifest.permission.BIND_INPUT_METHOD:
                desc = isChinese() ? "绑定到输入法" : "bind input method";
                break;
            case Manifest.permission.BIND_MIDI_DEVICE_SERVICE:
                desc = isChinese() ? "绑定到MIDI设备服务" : "bind midi device service";
                break;
            case Manifest.permission.BIND_NFC_SERVICE:
                desc = isChinese() ? "绑定到NFC服务" : "bind nfc service";
                break;
            case Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE:
                desc = isChinese() ? "绑定到通知监听服务" : "bind notification listener service";
                break;
            case Manifest.permission.BIND_PRINT_SERVICE:
                desc = isChinese() ? "绑定到打印服务" : "bind print service";
                break;
            case Manifest.permission.BIND_QUICK_SETTINGS_TILE:
                desc = isChinese() ? "绑定到快速设置" : "bind quick settings tile";
                break;
            case Manifest.permission.BIND_REMOTEVIEWS:
                desc = isChinese() ? "绑定到桌面部件服务" : "bind remoteviews";
                break;
            case Manifest.permission.BIND_SCREENING_SERVICE:
                desc = isChinese() ? "绑定到录屏服务" : "bind screening service";
                break;
            case Manifest.permission.BIND_TELECOM_CONNECTION_SERVICE:
                desc = isChinese() ? "绑定到通讯服务" : "bind telecom connection service";
                break;
            case Manifest.permission.BIND_TEXT_SERVICE:
                desc = isChinese() ? "绑定到文字服务" : "bind text service";
                break;
            case Manifest.permission.BIND_TV_INPUT:
                desc = isChinese() ? "绑定到TV输入服务" : "bind tv input";
                break;
            case Manifest.permission.BIND_VISUAL_VOICEMAIL_SERVICE:
                desc = isChinese() ? "绑定到虚拟语音邮件服务" : "bind visual voicemail service";
                break;
            case Manifest.permission.BIND_VOICE_INTERACTION:
                desc = isChinese() ? "绑定到语音交互" : "bind voice interaction";
                break;
            case Manifest.permission.BIND_VPN_SERVICE:
                desc = isChinese() ? "绑定到VPN服务" : "bind vpn service";
                break;
            case Manifest.permission.BIND_VR_LISTENER_SERVICE:
                desc = isChinese() ? "绑定到VR监听服务" : "bind vr listener service";
                break;
            case Manifest.permission.BIND_WALLPAPER:
                desc = isChinese() ? "绑定到桌面背景服务" : "bind wallpaper";
                break;
            case Manifest.permission.BLUETOOTH:
                desc = isChinese() ? "使用蓝牙" : "bluetooth";
                break;
            case Manifest.permission.BLUETOOTH_ADMIN:
                desc = isChinese() ? "管理蓝牙" : "bluetooth admin";
                break;
            case Manifest.permission.BLUETOOTH_PRIVILEGED:
                desc = isChinese() ? "无需用户交互的情况操作蓝牙" : "bluetooth privileged";
                break;
            case Manifest.permission.BROADCAST_PACKAGE_REMOVED:
                desc = isChinese() ? "广播应用程序包已被删除的通知" : "broadcast package removed";
                break;
            case Manifest.permission.BROADCAST_SMS:
                desc = isChinese() ? "广播短讯收据通知" : "broadcast sms";
                break;
            case Manifest.permission.BROADCAST_STICKY:
                desc = isChinese() ? "广播粘性意图" : "broadcast sticky";
                break;
            case Manifest.permission.BROADCAST_WAP_PUSH:
                desc = isChinese() ? "广播WAP PUSH收据通知" : "broadcast wap push";
                break;
            case Manifest.permission.CALL_COMPANION_APP:
                desc = isChinese() ? "调用配套应用" : "call companion app";
                break;
            case Manifest.permission.CALL_PRIVILEGED:
                desc = isChinese() ? "允许应用程式拨打任何电话号码" : "call privileged";
                break;
            case Manifest.permission.CAPTURE_AUDIO_OUTPUT:
                desc = isChinese() ? "捕获声音输出" : "capture audio output";
                break;
            case Manifest.permission.CHANGE_COMPONENT_ENABLED_STATE:
                desc = isChinese() ? "允许应用程序更改是否启用应用程序组件" : "change component enabled state";
                break;
            case Manifest.permission.CHANGE_CONFIGURATION:
                desc = isChinese() ? "允许应用程序修改当前配置" : "change configuration";
                break;
            case Manifest.permission.CHANGE_NETWORK_STATE:
                desc = isChinese() ? "修改网络状态" : "change network state";
                break;
            case Manifest.permission.CHANGE_WIFI_MULTICAST_STATE:
                desc = isChinese() ? "修改WIFI多播状态" : "change wifi multicast state";
                break;
            case Manifest.permission.CHANGE_WIFI_STATE:
                desc = isChinese() ? "修改WIFI状态" : "change wifi state";
                break;
            case Manifest.permission.CLEAR_APP_CACHE:
                desc = isChinese() ? "清空应用缓存" : "clear app cache";
                break;
            case Manifest.permission.CONTROL_LOCATION_UPDATES:
                desc = isChinese() ? "控制定位的更新" : "control location updates";
                break;
            case Manifest.permission.DELETE_CACHE_FILES:
                desc = isChinese() ? "删除缓存文件" : "delete cache files";
                break;
            case Manifest.permission.DELETE_PACKAGES:
                desc = isChinese() ? "删除应用" : "delete packages";
                break;
            case Manifest.permission.DIAGNOSTIC:
                desc = isChinese() ? "允许应用程序读取RW到诊断资源" : "diagnostic";
                break;
            case Manifest.permission.DISABLE_KEYGUARD:
                desc = isChinese() ? "关闭键盘锁" : "disable keyguard";
                break;
            case Manifest.permission.DUMP:
                desc = isChinese() ? "允许应用程序从系统服务中检索状态转储信息" : "dump";
                break;
            case Manifest.permission.EXPAND_STATUS_BAR:
                desc = isChinese() ? "展开状态栏" : "expand status bar";
                break;
            case Manifest.permission.FACTORY_TEST:
                desc = isChinese() ? "允许访问工厂测试" : "factory test";
                break;
            case Manifest.permission.FOREGROUND_SERVICE:
                desc = isChinese() ? "允许即时应用创建前台服务" : "foreground service";
                break;
            case Manifest.permission.GET_ACCOUNTS_PRIVILEGED:
                desc = isChinese() ? "访问帐户服务中的帐户列表" : "get accounts privileged";
                break;
            case Manifest.permission.GET_PACKAGE_SIZE:
                desc = isChinese() ? "获取应用包大小" : "get package size";
                break;
            case Manifest.permission.GET_TASKS:
                desc = isChinese() ? "获取任务" : "get tasks";
                break;
            case Manifest.permission.GLOBAL_SEARCH:
                desc = isChinese() ? "使用全局搜索" : "global search";
                break;
            case Manifest.permission.INSTALL_LOCATION_PROVIDER:
                desc = isChinese() ? "序将位置提供程序安装到位置管理器中" : "install location provider";
                break;
            case Manifest.permission.INSTALL_PACKAGES:
                desc = isChinese() ? "安装应用" : "install packages";
                break;
            case Manifest.permission.INSTALL_SHORTCUT:
                desc = isChinese() ? "添加快捷方式" : "install shortcut";
                break;
            case Manifest.permission.INSTANT_APP_FOREGROUND_SERVICE:
                desc = isChinese() ? "允许即时应用创建前台服务" : "instant app foreground service";
                break;
            case Manifest.permission.INTERNET:
                desc = isChinese() ? "使用网络" : "internet";
                break;
            case Manifest.permission.KILL_BACKGROUND_PROCESSES:
                desc = isChinese() ? "清理后台进程" : "kill background processes";
                break;
            case Manifest.permission.LOCATION_HARDWARE:
                desc = isChinese() ? "允许应用程序在硬件中使用位置功能" : "location hardware";
                break;
            case Manifest.permission.MANAGE_DOCUMENTS:
                desc = isChinese() ? "管理文件" : "manage documents";
                break;
            case Manifest.permission.MANAGE_OWN_CALLS:
                desc = isChinese() ? "管理自己的通话" : "manage own calls";
                break;
            case Manifest.permission.MASTER_CLEAR:
                desc = isChinese() ? "恢复出厂设置" : "master clear";
                break;
            case Manifest.permission.MEDIA_CONTENT_CONTROL:
                desc = isChinese() ? "控制多媒体内容" : "media content control";
                break;
            case Manifest.permission.MODIFY_AUDIO_SETTINGS:
                desc = isChinese() ? "修改声音设置" : "modify audio settings";
                break;
            case Manifest.permission.MODIFY_PHONE_STATE:
                desc = isChinese() ? "修改电话状态" : "modify phone state";
                break;
            case Manifest.permission.MOUNT_FORMAT_FILESYSTEMS:
                desc = isChinese() ? "格式化可移动存储" : "mount format filesystems";
                break;
            case Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS:
                desc = isChinese() ? "安装和卸载可移动存储的文件系统" : "mount unmount filesystems";
                break;
            case Manifest.permission.NFC:
                desc = isChinese() ? "MFC" : "nfc";
                break;
            case Manifest.permission.NFC_TRANSACTION_EVENT:
                desc = isChinese() ? "读取NFC传输事件" : "nfc transaction event";
                break;
            case Manifest.permission.PACKAGE_USAGE_STATS:
                desc = isChinese() ? "应用使用空间状态" : "package usage stats";
                break;
            case Manifest.permission.PERSISTENT_ACTIVITY:
                desc = isChinese() ? "允许应用程序使其活动持久化" : "persistent activity";
                break;
            case Manifest.permission.READ_INPUT_STATE:
                desc = isChinese() ? "读取输入状态" : "read input state";
                break;
            case Manifest.permission.READ_LOGS:
                desc = isChinese() ? "读取系统日志" : "read logs";
                break;
            case Manifest.permission.READ_PHONE_NUMBERS:
                desc = isChinese() ? "读取电话号码" : "read phone numbers";
                break;
            case Manifest.permission.READ_SYNC_SETTINGS:
                desc = isChinese() ? "读取同步设置" : "read sync settings";
                break;
            case Manifest.permission.READ_SYNC_STATS:
                desc = isChinese() ? "读取同步状态" : "read sync stats";
                break;
            case Manifest.permission.READ_VOICEMAIL:
                desc = isChinese() ? "读取语音邮件" : "read voicemail";
                break;
            case Manifest.permission.REBOOT:
                desc = isChinese() ? "重启" : "reboot";
                break;
            case Manifest.permission.RECEIVE_BOOT_COMPLETED:
                desc = isChinese() ? "接受启动完成广播" : "receive boot completed";
                break;
            case Manifest.permission.REORDER_TASKS:
                desc = isChinese() ? "更改任务的顺序" : "reorder tasks";
                break;
            case Manifest.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND:
                desc = isChinese() ? "允许配套应用在后台运行" : "request companion run in background";
                break;
            case Manifest.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND:
                desc = isChinese() ? "允许配套应用在后台使用数据" : "request companion use data in background";
                break;
            case Manifest.permission.REQUEST_DELETE_PACKAGES:
                desc = isChinese() ? "请求删除应用" : "request delete packages";
                break;
            case Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS:
                desc = isChinese() ? "请求忽略电池优化策略" : "request ignore battery optimizations";
                break;
            case Manifest.permission.REQUEST_INSTALL_PACKAGES:
                desc = isChinese() ? "请求安装应用" : "request install packages";
                break;
            case Manifest.permission.REQUEST_PASSWORD_COMPLEXITY:
                desc = isChinese() ? "请求验证密码复杂度" : "request password complexity";
                break;
            case Manifest.permission.RESTART_PACKAGES:
                desc = isChinese() ? "重启应用" : "restart packages";
                break;
            case Manifest.permission.SEND_RESPOND_VIA_MESSAGE:
                desc = isChinese() ? "通过短信发送回复" : "send respond via message";
                break;
            case Manifest.permission.SET_ALARM:
                desc = isChinese() ? "设置闹钟" : "set alarm";
                break;
            case Manifest.permission.SET_ALWAYS_FINISH:
                desc = isChinese() ? "允许应用程序控制放置在后台时是否立即完成活动" : "set always finish";
                break;
            case Manifest.permission.SET_ANIMATION_SCALE:
                desc = isChinese() ? "设置动画缩放" : "set animation scale";
                break;
            case Manifest.permission.SET_DEBUG_APP:
                desc = isChinese() ? "设置调试应用" : "set debug app";
                break;
            case Manifest.permission.SET_PREFERRED_APPLICATIONS:
                desc = isChinese() ? "设置优先应用" : "set preferred applications";
                break;
            case Manifest.permission.SET_PROCESS_LIMIT:
                desc = isChinese() ? "设置进程限制" : "set process limit";
                break;
            case Manifest.permission.SET_TIME:
                desc = isChinese() ? "设置时间" : "set time";
                break;
            case Manifest.permission.SET_TIME_ZONE:
                desc = isChinese() ? "设置时区" : "set time zone";
                break;
            case Manifest.permission.SET_WALLPAPER:
                desc = isChinese() ? "设置壁纸" : "set wallpaper";
                break;
            case Manifest.permission.SET_WALLPAPER_HINTS:
                desc = isChinese() ? "设置壁纸提示" : "set wallpaper hints";
                break;
            case Manifest.permission.SIGNAL_PERSISTENT_PROCESSES:
                desc = isChinese() ? "允许应用程序请求将信号发送到所有持久性进程" : "signal persistent processes";
                break;
            case Manifest.permission.SMS_FINANCIAL_TRANSACTIONS:
                desc = isChinese() ? "允许财务应用读取过滤信息" : "sms financial transactions";
                break;
            case Manifest.permission.STATUS_BAR:
                desc = isChinese() ? "修改状态栏" : "status bar";
                break;
            case Manifest.permission.SYSTEM_ALERT_WINDOW:
                desc = isChinese() ? "使用系统弹窗" : "system alert window";
                break;
            case Manifest.permission.TRANSMIT_IR:
                desc = isChinese() ? "使用红外设备" : "transmit ir";
                break;
            case Manifest.permission.UNINSTALL_SHORTCUT:
                desc = isChinese() ? "删除快捷方式" : "uninstall shortcut";
                break;
            case Manifest.permission.UPDATE_DEVICE_STATS:
                desc = isChinese() ? "更新设备状态" : "update device stats";
                break;
            case Manifest.permission.USE_BIOMETRIC:
                desc = isChinese() ? "使用生物识别设备" : "use biometric";
                break;
            case Manifest.permission.USE_FINGERPRINT:
                desc = isChinese() ? "使用指纹设备" : "use fingerprint";
                break;
            case Manifest.permission.USE_FULL_SCREEN_INTENT:
                desc = isChinese() ? "使用全屏的意图" : "use full screen intent";
                break;
            case Manifest.permission.VIBRATE:
                desc = isChinese() ? "振动" : "vibrate";
                break;
            case Manifest.permission.WAKE_LOCK:
                desc = isChinese() ? "唤醒锁" : "wake lock";
                break;
            case Manifest.permission.WRITE_APN_SETTINGS:
                desc = isChinese() ? "修改APN设置" : "write apn settings";
                break;
            case Manifest.permission.WRITE_GSERVICES:
                desc = isChinese() ? "修改谷歌地图服务" : "write gservices";
                break;
            case Manifest.permission.WRITE_SECURE_SETTINGS:
                desc = isChinese() ? "修改系统安全设置" : "write secure settings";
                break;
            case Manifest.permission.WRITE_SETTINGS:
                desc = isChinese() ? "修改系统设置" : "write settings";
                break;
            case Manifest.permission.WRITE_SYNC_SETTINGS:
                desc = isChinese() ? "修改同步设置" : "write sync settings";
                break;
            case Manifest.permission.WRITE_VOICEMAIL:
                desc = isChinese() ? "修改语音邮件" : "write voicemail";
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
