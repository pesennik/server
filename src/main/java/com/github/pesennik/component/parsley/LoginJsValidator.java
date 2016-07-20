package com.github.pesennik.component.parsley;


import com.github.pesennik.util.Limits;
import com.github.pesennik.util.Plurals;

public class LoginJsValidator extends RequiredFieldJsValidator {
    public LoginJsValidator() {
        attributeMap.put("data-parsley-minlength", Limits.LOGIN_MIN_LENGTH);
        attributeMap.put("data-parsley-maxlength", Limits.LOGIN_MAX_LENGTH);
        //TODO: translations?
        attributeMap.put("data-parsley-minlength-message", "Мин. длина имени пользователя: " + Plurals.npl(Limits.LOGIN_MIN_LENGTH, " symbol"));
        attributeMap.put("data-parsley-maxlength-message", "Имя пользователя не может превышать " + Plurals.npl(Limits.LOGIN_MAX_LENGTH, " symbol"));
    }

}