package com.multi.webcommon.util;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class NullUtil {
    public static boolean isNotNullOrEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isNullOrEmpty(Object object) {
        return isEmpty(object);
    }

    public static boolean isNotNullOrEmpty(Object... obj) {
        return !isNullOrEmpty(obj);
    }

    public static boolean isNullOrEmpty(Object... obj) {
        if (obj == null) {
            return true;
        }
        for (Object s : obj) {
            if (isNullOrEmpty(s)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            return ((String) obj).trim().length() == 0;
        } else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else {
            return obj instanceof Map ? ((Map) obj).isEmpty() : false;
        }
    }
}
