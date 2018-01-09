package br.com.guilherme.lemes.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * @author Guilherme Geraldo <guilherme.lemes@guilherme.com>
 */
public class CommonUtil {
	
	public static boolean isNotNullOrNotEmpty(Object object){
		return !isNullOrEmpty(object);
	}
	
    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Object object) {
        boolean nullOrEmpty = false;
        if (object == null) {
            nullOrEmpty = true;
        } else {
            if (object instanceof Collection) {
                if (((Collection) object).size() == 0) {
                    nullOrEmpty = true;
                }
            } else if (object instanceof String) {
                if (((String) object).length() == 0) {
                    nullOrEmpty = true;
                }
            }
        }
        return nullOrEmpty;
    }

    public static String toString(Object str) {
        if (str != null)
            return String.valueOf(str).trim();

        return "";
    }

    public static String getSHA1(String password) throws NoSuchAlgorithmException {

        if (!CommonUtil.isNullOrEmpty(password)) {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            StringBuffer hexString = new StringBuffer();
            for (byte aHash : hash) {
                if ((0xff & aHash) < 0x10)
                    hexString.append("0" + Integer.toHexString((0xFF & aHash)));
                else
                    hexString.append(Integer.toHexString(0xFF & aHash));
            }
            return hexString.toString();
        }
        return null;

    }
}
