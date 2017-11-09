package com.base;

import java.util.List;

public class Helpers {

    public static String buildUrlWithQuery(String url, List<String> parameters) {
        return url.concat("?").concat(String.join("&", parameters));
    }
}
