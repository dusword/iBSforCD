package com.lxjtest.util;


import com.lxjtest.constant.ApiErrorCode;

import java.util.List;
import java.util.Map;

/**
 * 用户系统ajax的统一返回消息
 * @author tian.kui
 */
public class AjaxResult {
    /**操作结果 0为成功*/
    private int status = 200;
    /**错误code*/
    private String statusCode = "0";
    /**操作结果描述信息*/
    private String statusInfo = "SUCCESS";
    private Integer totalCount = 0;
    /**操作返回数据绑定*/
    private Object data;
    public final static AjaxResult SUCCESSRESULT = new AjaxResult();

    public AjaxResult(){}

    public AjaxResult(int status, String statusCode, String statusInfo) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusInfo = statusInfo;
    }

    public AjaxResult(Object data , Integer totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getStatusInfo() {
        return statusInfo;
    }
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setTotalCount(Integer totalCount){this.totalCount = totalCount;}

    public static AjaxResult result(int status, String code, String info){
        AjaxResult res = new AjaxResult();
        res.status = status;
        res.statusCode = code;
        res.statusInfo = info;
        return res;
    }
    public static AjaxResult result(int status, String code, String info, Object data){
        AjaxResult res = new AjaxResult();
        res.status = status;
        res.statusCode = code;
        res.statusInfo = info;
        res.data = data;
        return res;
    }
    public static AjaxResult success(Object data){
        AjaxResult res = new AjaxResult();
        res.setData(data);
        return res;
    }
    public static AjaxResult success(String msg){
        AjaxResult res = new AjaxResult();
        res.setStatusInfo(msg);
        return res;
    }
    public static AjaxResult success(){
        AjaxResult res = new AjaxResult();
        return res;
    }
    /*public String toJsonString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }*/

    public static AjaxResult fail(String msg){
        AjaxResult res = new AjaxResult();
        res.setStatus(new Integer(ApiErrorCode.FAIL.getCode()));
        res.setStatusCode(ApiErrorCode.FAIL.getDesc());
        res.setStatusInfo(msg);
        return res;
    }

    public static AjaxResult fail(String msg , Object data){
        AjaxResult res = new AjaxResult();
        res.setStatus(new Integer(ApiErrorCode.FAIL.getCode()));
        res.setStatusCode(ApiErrorCode.FAIL.getDesc());
        res.setStatusInfo(msg);
        res.setData(data);
        return res;
    }

    public static AjaxResult success(List returnParams){
        if(returnParams == null){
            AjaxResult ajaxResult = new AjaxResult(null , 0);
            return ajaxResult;
        }
        AjaxResult ajaxResult = new AjaxResult(returnParams , returnParams.size());
        return ajaxResult;
    }

    public static AjaxResult success(Map returnParams){
        if(returnParams == null){
            AjaxResult ajaxResult = new AjaxResult(null , 0);
            return ajaxResult;
        }
        AjaxResult ajaxResult = new AjaxResult(returnParams , returnParams.size());
        return ajaxResult;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "status=" + status +
                ", statusCode='" + statusCode + '\'' +
                ", statusInfo='" + statusInfo + '\'' +
                ", totalCount=" + totalCount +
                ", data=" + data +
                '}';
    }
}
