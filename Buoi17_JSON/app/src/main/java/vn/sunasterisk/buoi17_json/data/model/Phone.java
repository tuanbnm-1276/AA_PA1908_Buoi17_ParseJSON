package vn.sunasterisk.buoi17_json.data.model;

import androidx.annotation.NonNull;

public class Phone {
    private String mMobile;
    private String mHome;
    private String mOffice;

    public Phone() {
    }

    public Phone(String mobile, String home, String office) {
        mMobile = mobile;
        mHome = home;
        mOffice = office;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getHome() {
        return mHome;
    }

    public void setHome(String home) {
        mHome = home;
    }

    public String getOffice() {
        return mOffice;
    }

    public void setOffice(String office) {
        mOffice = office;
    }

    @NonNull
    @Override
    public String toString() {
        return mMobile;
    }
}
