package vn.sunasterisk.buoi17_json.data.source.remote;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vn.sunasterisk.buoi17_json.constant.Constant;
import vn.sunasterisk.buoi17_json.constant.ContactEntity;
import vn.sunasterisk.buoi17_json.constant.PhoneEntity;
import vn.sunasterisk.buoi17_json.data.model.Contact;
import vn.sunasterisk.buoi17_json.data.model.Phone;
import vn.sunasterisk.buoi17_json.data.source.ContactsDataSource;

public class FetchContactsFromUrl extends AsyncTask<String, Void, List<Contact>> {

    private ContactsDataSource.OnFetchDataListener<Contact> mListener;
    private Exception mException;

    public void setListener(ContactsDataSource.OnFetchDataListener<Contact> listener) {
        mListener = listener;
    }

    @Override
    protected List<Contact> doInBackground(String... strings) {
        String url = strings[0];

        try {
            String data = getStringDataFromUrl(url);
            return getContactsFromStringData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<Contact> getContactsFromStringData(String data) throws JSONException {
        List<Contact> contacts = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray = object.getJSONArray(ContactEntity.CONTACTS);
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String id = jsonObject.getString(ContactEntity.ID);
            String name = jsonObject.getString(ContactEntity.NAME);
            String email = jsonObject.getString(ContactEntity.EMAIL);
            String address = jsonObject.getString(ContactEntity.ADDRESS);
            String gender = jsonObject.getString(ContactEntity.GENDER);

            JSONObject jsonPhone = jsonObject.getJSONObject(ContactEntity.PHONE);
            String mobile = jsonPhone.getString(PhoneEntity.MOBILE);
            String home = jsonPhone.getString(PhoneEntity.HOME);
            String office = jsonPhone.getString(PhoneEntity.OFFICE);

            Phone phone = new Phone(mobile, home, office);
            Contact contact = new Contact(id, name, email, address, gender, phone);
            contacts.add(contact);
        }
        return contacts;
    }

    private String getStringDataFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONNECT_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);
        connection.setDoOutput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(List<Contact> contacts) {
        if(mListener == null) return;
        if(mException == null){
            mListener.onFetchDataSuccess(contacts);
        }else {
            mListener.onFetchDataFailure(mException);
        }
    }
}
