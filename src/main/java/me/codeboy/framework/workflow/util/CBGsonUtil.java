package me.codeboy.framework.workflow.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 处理json类
 *
 * @author YD
 */
public class CBGsonUtil {
    private static Gson gson;
    private static String timeFormat = "yyyy-MM-dd HH:mm:ss";  //时间格式

    /**
     * 获取gson对象
     *
     * @return gson
     */
    public static Gson getInstance() {
        if (gson == null) {
            gson = new GsonBuilder().setDateFormat(timeFormat)
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }
        return gson;
    }

    /**
     * 设置时间格式
     * @param timeFormat 时间格式
     */
    public static void setTimeFormat(String timeFormat) {
        CBGsonUtil.timeFormat = timeFormat;
    }

}