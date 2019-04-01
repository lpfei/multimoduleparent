package com.multi.webcommon.util;


import java.util.Collection;

/**
 * Created by zhuxh on 2017/12/9.
 */
public class NullUtil {
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }

        if (obj instanceof String) {
            String str = ((String) obj).trim();
            if (str.equals("") || str.equals("null")) {
                return true;
            }
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).size() <= 0) {
                return true;
            }
        }
        if (obj.getClass().isArray()) {

        }
        if (obj instanceof Object[]) {
            int length = ((Object[]) obj).length;
            if (length <= 0 || (length == 1 && isEmpty(((Object[]) obj)[0]))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 任一项empty=true
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object... obj) {
        if (null == obj) {
            return true;
        }
        for (Object s : obj) {
            if (isEmpty(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * empty=defaultStr
     *
     * @param object
     * @param def
     * @return
     */
    public static String isEmptyDefault(Object object, String def) {
        String str = String.valueOf(object);
        if (isEmpty(str)) {
            return def;
        }
        return str;
    }
}
