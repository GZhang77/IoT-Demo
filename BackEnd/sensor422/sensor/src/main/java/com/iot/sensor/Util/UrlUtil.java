package com.iot.sensor.Util;

import org.springframework.util.AntPathMatcher;

public class UrlUtil {

    private static final String AUTH_URL_PATTERN = "/api/auth/**";
    private static final String EVENT_SAVE_PATTERN = "/api/events/save";

    private static final AntPathMatcher apm = new AntPathMatcher();

    public static boolean isAuthUrl(String requestUrl) {
        return apm.match(AUTH_URL_PATTERN, requestUrl);
    }
    public static boolean isSaveUrl(String requestUrl) {
        return apm.match(EVENT_SAVE_PATTERN, requestUrl);
    }
}
