package vn.sunasterisk.buoi17_json.data.source;

import java.util.List;

public interface ContactsDataSource {

    interface OnFetchDataListener<T>{
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }
}
