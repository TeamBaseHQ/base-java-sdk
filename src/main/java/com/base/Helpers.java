package com.base;

import java.util.Iterator;
import java.util.List;

public class Helpers {

    /**
     * Join List Elements with a String.
     *
     * @param glue String to glue list elements.
     * @param list List of elements.
     * @param <T>  List element type.
     * @return String
     */
    public static <T> String implode(String glue, List<T> list) {
        // list is empty, return empty string
        if (list == null || list.isEmpty()) {
            return "";
        }

        Iterator<T> iter = list.iterator();

        // init the builder with the first element
        StringBuilder sb = new StringBuilder();
        sb.append(iter.next());

        // concat each element
        while (iter.hasNext()) {
            sb.append(glue).append(iter.next());
        }

        // return result
        return sb.toString();
    }

    /**
     * Build URL with Query
     *
     * @param url
     * @param parameters
     * @return URL
     */
    public static String buildUrlWithQuery(String url, List<String> parameters) {
        if (parameters.size() < 1) {
            return url;
        }

        return url.concat("?").concat(Helpers.implode("&", parameters));
    }
}
