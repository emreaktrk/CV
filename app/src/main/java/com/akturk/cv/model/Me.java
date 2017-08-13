package com.akturk.cv.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Me extends GenericJson {

    @Key public String _id;
    @Key public String _fullname;
    @Key public String _profession;
    @Key public String _location;
    @Key public String _about;
    @Key public String _phone;
    @Key public String _email;

    public Me() {
    }
}
