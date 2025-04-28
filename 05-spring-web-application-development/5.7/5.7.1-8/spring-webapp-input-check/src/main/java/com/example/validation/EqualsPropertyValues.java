package com.example.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {EqualsPropertyValuesValidator.class}) 
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface EqualsPropertyValues {
	
	String message() default "{com.example.inputcheck.validation.EqualsPropertyValues.message}"; 
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String property();
	String comparingProperty();
	
	@Target({ TYPE, ANNOTATION_TYPE }) 
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		EqualsPropertyValues[] value(); 
	}
	
}
