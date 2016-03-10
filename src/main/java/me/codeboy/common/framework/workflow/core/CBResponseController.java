package me.codeboy.common.framework.workflow.core;

import com.google.gson.reflect.TypeToken;
import me.codeboy.common.base.log.CBPrint;
import me.codeboy.common.framework.workflow.bean.CBCommonResult;
import me.codeboy.common.framework.workflow.util.CBGsonUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

/**
 * process and wrap data, then push data to client
 *
 * @author yuedong.li
 */
public class CBResponseController {

    /**
     * process and wrap data
     *
     * @param result result data
     */
    public static <T> void process(T result) {
        process(new CBCommonResult<>(result));
    }


    /**
     * process data
     *
     * @param result result data
     */
    public static <T> void process(CBCommonResult<T> result) {
        process(result, new TypeToken<CBCommonResult<T>>() {
        }.getType());
    }


    /**
     * process raw data
     *
     * @param result result
     */
    public static <T> void processRaw(T result) {
        process(result, new TypeToken<T>() {
        }.getType());
    }

    /**
     * process data and push data to client
     *
     * @param result result data
     * @param type   data type
     */
    private static <T> void process(T result, Type type) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write(CBGsonUtil.getInstance().toJson(result, type));
            out.flush();
            out.close();
        } catch (IOException e) {
            CBPrint.log(e.getMessage());
            e.printStackTrace();
        }
    }
}