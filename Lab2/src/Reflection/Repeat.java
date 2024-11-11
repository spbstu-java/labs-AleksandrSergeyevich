package Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме через рефлексию
public @interface Repeat {
    int value();
}