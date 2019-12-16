package co.g2lab.crud.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GetNasabah {
    @SerializedName("status")
    String status;
    @SerializedName("code")
    Integer code;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    List<Nasabah> listNasabah;

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

    public List<Nasabah> getListNasabah() {
        return listNasabah;
    }

    public void setListNasabah(List<Nasabah> listNasabah) {
        this.listNasabah = listNasabah;
    }
}
