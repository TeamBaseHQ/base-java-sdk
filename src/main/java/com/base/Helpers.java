package com.base;

import java.util.List;

public class Helpers {

    /**
     * Build URL with Query
     *
     * @param url
     * @param parameters
     * @return URL
     */
    public static String buildUrlWithQuery(String url, List<String> parameters) {
        return url.concat("?").concat(String.join("&", parameters));
    }
}
