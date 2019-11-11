package vn.sunasterisk.buoi17_json.screen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import vn.sunasterisk.buoi17_json.R;
import vn.sunasterisk.buoi17_json.constant.Constant;
import vn.sunasterisk.buoi17_json.data.model.Contact;
import vn.sunasterisk.buoi17_json.data.source.ContactsDataSource;
import vn.sunasterisk.buoi17_json.data.source.remote.FetchContactsFromUrl;

public class MainActivity extends AppCompatActivity
        implements ContactsDataSource.OnFetchDataListener<Contact> {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FetchContactsFromUrl fetchContactsFromUrl = new FetchContactsFromUrl();
        fetchContactsFromUrl.setListener(this);
        fetchContactsFromUrl.execute(Constant.BASE_URL);
    }

    @Override
    public void onFetchDataSuccess(List<Contact> contacts) {
        Log.d(TAG, "onFetchDataSuccess: SIZE is " + contacts.size());
        for (int i = 0; i < contacts.size(); i++) {
            Log.d(TAG, "onFetchDataSuccess: " + contacts.get(i).toString());
        }
    }

    @Override
    public void onFetchDataFailure(Exception e) {
        Toast.makeText(this, "ERROR " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
