package com.example.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { PasswordValidator.class })
@Target({FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface Password {
	
    String message() default "Invalid password, must >= 8 characters within 1 non-alphanumeric character! (example: 1zxc#2sd)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int length() default 8;
    int nonAlpha() default 1;
}
