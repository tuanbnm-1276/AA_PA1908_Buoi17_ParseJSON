package vn.sunasterisk.buoi17_json.data.model;

import androidx.annotation.NonNull;

public class Contact {
    private String mId;
    private String mName;
    private String mEmail;
    private String mAddress;
    private String mGender;
    private Phone mPhone;

    public Contact() {
    }

    public Contact(String id, String name,
                   String email, String address,
                   String gender, Phone phone) {
        mId = id;
        mName = name;
        mEmail = email;
        mAddress = address;
        mGender = gender;
        mPhone = phone;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public Phone getPhone() {
        return mPhone;
    }

    public void setPhone(Phone phone) {
        mPhone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return mName + " " + mPhone.toString();
    }
}
