package me.codeboy.common.framework.workflow.bean;

import com.google.gson.annotations.Expose;
import me.codeboy.common.framework.workflow.core.CBCommonResultCode;

/**
 * 通用结果
 * Created by yuedong.li on 12/26/15.
 */
public class CBCommonResult<T> {
    @Expose
    private int code = CBCommonResultCode.SUCCESS.value(); //执行码
    @Expose
    private T data; //数据
    @Expose
    private String description; //描述

    public CBCommonResult(T data) {
        this.data = data;
    }

    public CBCommonResult(CBCommonResultCode code, String description) {
        this.code = code.value();
        this.description = description;
    }

    public CBCommonResult(CBCommonResultCode code, T data, String description) {
        this.code = code.value();
        this.description = description;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
