package com.base.Http.Request;

public class JSONRequestBody implements RequestBody {

    protected String encodedBody;

    public JSONRequestBody(Object data) {
        this.encodedBody = data.toString();
    }

    public String getBody() {
        return this.encodedBody;
    }
}
