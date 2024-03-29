package co.g2lab.crud.model;

import com.google.gson.annotations.SerializedName;

public class GetNasabah {
    @SerializedName("status")
    String status;
    @SerializedName("code")
    Integer code;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    Nasabah nasabah;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
}
