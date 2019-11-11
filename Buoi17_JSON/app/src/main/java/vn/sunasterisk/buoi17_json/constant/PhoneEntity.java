package vn.sunasterisk.buoi17_json.constant;

import androidx.annotation.StringDef;

@StringDef({
        PhoneEntity.MOBILE,
        PhoneEntity.HOME,
        PhoneEntity.OFFICE
})

public @interface PhoneEntity {
    String MOBILE = "mobile";
    String HOME = "home";
    String OFFICE = "office";
}
