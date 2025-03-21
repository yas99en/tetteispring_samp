package mrs.app.reservation;

import java.time.LocalTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// 14.2.7.4. 入力チェックの実装 ThirtyMinutesUnitValidator.java
public class ThirtyMinutesUnitValidator implements ConstraintValidator<ThirtyMinutesUnit, LocalTime> {
	
	@Override
	public void initialize(ThirtyMinutesUnit constraintAnnotation) {
	}

	@Override
	public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		return value.getMinute() % 30 == 0;
	}
	
}