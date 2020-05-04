package com.canis.his.useful;

/**
 * 封装了返回给前端的数据类型
 * @param <T>
 */
public class Response<T> {
    private int status;
    private int flag;
    private T data;

    public Response(int status, T data){
        this.status =status;
        this.flag = 0;
        this.data=data;

    }
    public Response(T data){
        this.status =200;
        this.flag = 0;
        this.data=data;
    }

    public Response(int status, int flag, T data) {
        this.status = status;
        this.flag = flag;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}


