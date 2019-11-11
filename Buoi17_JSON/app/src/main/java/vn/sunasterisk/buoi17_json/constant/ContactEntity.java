package vn.sunasterisk.buoi17_json.constant;

import androidx.annotation.StringDef;

@StringDef({
        ContactEntity.CONTACTS,
        ContactEntity.ID,
        ContactEntity.NAME,
        ContactEntity.EMAIL,
        ContactEntity.ADDRESS,
        ContactEntity.GENDER,
        ContactEntity.PHONE
})
public @interface ContactEntity {
    String CONTACTS = "contacts";
    String ID = "id";
    String NAME = "name";
    String EMAIL = "email";
    String ADDRESS = "address";
    String GENDER = "gender";
    String PHONE = "phone";
}
