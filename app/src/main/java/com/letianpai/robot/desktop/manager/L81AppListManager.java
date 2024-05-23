package com.letianpai.robot.desktop.manager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.letianpai.robot.components.network.nets.GeeUiNetManager;
import com.letianpai.robot.components.network.system.SystemUtil;
import com.letianpai.robot.components.storage.RobotSubConfigManager;
import com.letianpai.robot.desktop.R;
import com.letianpai.robot.desktop.apps.adapter.AppListItem;
import com.letianpai.robot.desktop.callback.AppMenuUpdateCallback;
import com.letianpai.robot.desktop.parser.AppMenuInfo;
import com.letianpai.robot.desktop.parser.RobotMenu;
import com.letianpai.robot.desktop.storage.RobotConfigManager;
import com.letianpai.robot.desktop.utils.AppTagConsts;
import com.letianpai.robot.desktop.utils.FunctionUtils;
import com.letianpai.robot.desktop.utils.OpenTypeConsts;
import com.letianpai.robot.desktop.utils.PackageConsts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author liujunbin
 */
public class L81AppListManager {

    private static L81AppListManager sInstance = null;
    private Context mContext;
    private ArrayList<String> robotPackageList = new ArrayList<>();

    public L81AppListManager(Context context) {
        this.mContext = context;
        initPackageList();
    }


    public static L81AppListManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (L81AppListManager.class) {
                if (sInstance == null) {
                    sInstance = new L81AppListManager(context);
                }
            }
        }
        return sInstance;
    }

    private void initPackageList() {
        robotPackageList.clear();
        robotPackageList.add(PackageConsts.TAKEPHOTO_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.ROBOT_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.LAUNCHER_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.AUTO_APP_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.LEX_CLASS_PACKAGE);
        robotPackageList.add(PackageConsts.SPEECH_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.ALARM_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.STOCK_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.WEATHER_PACKAGE_NAME);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_COUNT_DOWN);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_COMMEMORATION);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_WORDS);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_NEWS);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_MESSAGE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_FANS);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_IDENT);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_CUSTOM);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_VIDEO_CALL);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_LAMP);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_REMINDER);
        robotPackageList.add(PackageConsts.PACKAGE_APP_NAME_REMINDER);
        robotPackageList.add(PackageConsts.PACKAGE_APP_NAME_SPECTRUM);
        robotPackageList.add(PackageConsts.PACKAGE_APP_NAME_POMO);
        robotPackageList.add(PackageConsts.PACKAGE_APP_NAME_OTA);
        robotPackageList.add(PackageConsts.PACKAGE_APP_NAME_MEDITATION);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_TIME);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_EXPRESSION);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_ALBUM);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_WIFI_CONNECTOR);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GEEUI_SETTINGS);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_APP_STORE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_FIST_PALM_GAME);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_VOICE_MEMO);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_MCU_SERVICE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_APHORISMS);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GEEUI_RESOURCE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GEEUI_VIDEO_PLAYER);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GEEUI_DOWNLOADER);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GEEUI_MY_MUSIC);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_TASK_SERVICE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_DESKTOP);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_FACTORY);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_LOCAL_DOWNLOADER);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_INSTALLER);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_GUIDE);
        robotPackageList.add(PackageConsts.PACKAGE_NAME_FANS_SHOW);
    }

    public boolean isInThePackageList(String packageName) {
        if (robotPackageList == null || robotPackageList.size() == 0){
            return false;
        }
        if (robotPackageList.contains(packageName)) {
            return true;
        } else {
            return false;
        }
    }


}
