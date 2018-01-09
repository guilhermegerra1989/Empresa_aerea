package br.com.guilherme.lemes.common.util;

import java.text.DecimalFormat;

/**
 * @author Guilherme Geraldo <guilherme.lemes@guilherme.com>
 */
public class NumberUtil {

    public static String format(Object value, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);

        if (value != null)
            return decimalFormat.format(value);
        else
            return new String();
    }
}
