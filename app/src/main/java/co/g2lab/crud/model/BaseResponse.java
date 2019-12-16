package co.g2lab.crud.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T extends Object>{
    @SerializedName("status")
    public String status;
    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;

    public T data;
    public T pagination;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getPagination() {
        return pagination;
    }

    public void setPagination(T pagination) {
        this.pagination = pagination;
    }
}
