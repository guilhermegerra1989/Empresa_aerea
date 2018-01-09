/**
 *
 */
package br.com.guilherme.lemes.core.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Rodrigo Seidi Watanabe
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Prefix {

    String table() default "tbl";

    String column() default "col";
}
