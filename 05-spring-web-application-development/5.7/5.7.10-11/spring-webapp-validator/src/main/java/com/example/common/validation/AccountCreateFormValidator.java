package com.example.common.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.app.AccountCreateForm;

@Component
public class AccountCreateFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCreateForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasFieldErrors("type")) {
			return;
		}
		AccountCreateForm form = AccountCreateForm.class.cast(target);
		if ("1".equals(form.getType())) {
			if (StringUtils.hasLength(form.getCardNo())) {
				errors.rejectValue("cardNo", "Size");
			}
		} else {
			if (form.getCardNo() == null || form.getCardNo().length() < 14 || form.getCardNo().length() > 16) {
				errors.rejectValue("cardNo", "Size", new Object[]{14, 16}, null);
			}
		}
	}
}