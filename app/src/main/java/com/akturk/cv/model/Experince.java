package com.akturk.cv.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Experince extends GenericJson {

    @Key public String _id;
    @Key public String _profession;
    @Key public String _company;
    @Key public Integer _startDate;
    @Key public Integer _endDate;
    @Key public String _location;

    public Experince() {
    }
}
