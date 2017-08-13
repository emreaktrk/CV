package com.akturk.cv.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class Education extends GenericJson {

    @Key public String _id;
    @Key public String _content;
    @Key public String _subcontent;

    public Education() {
    }

}
