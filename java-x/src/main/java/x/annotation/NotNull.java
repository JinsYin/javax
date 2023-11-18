package x.annotation;

public @interface NotNull {
    String message() default "The object is null";
}
