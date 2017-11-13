package com.base.Http.Request;

public class JSONRequestBody implements RequestBody {

    /**
     * JSON Encoded Body
     */
    protected String encodedBody;

    /**
     * Request Request Body
     *
     * @param data
     */
    public JSONRequestBody(Object data) {
        this.encodedBody = data.toString();
    }

    /**
     * Return Body of Request
     *
     * @return Body
     */
    public String getBody() {
        return this.encodedBody;
    }
}
