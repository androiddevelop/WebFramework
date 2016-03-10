package me.codeboy.framework.workflow.core;

/**
 * 通用结果类型
 * Created by yuedong.li on 12/26/15.
 */
public enum CBCommonResultCode {

    SUCCESS(0), FAILED(-1), EXCEPTION(-2);

    private int value;

    CBCommonResultCode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
