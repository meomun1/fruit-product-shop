package com.itbulls.learnit.onlinestore.core.services.impl;

import com.itbulls.learnit.onlinestore.core.services.Validator;

public class PasswordValidator implements Validator {

    private static PasswordValidator instance;

    @Override
    public boolean isValidate(String password) {
        if( password.length() < 8){
            return false;
        }

        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";

        for(int i = 0 ; i < password.length(); i++){
            char c = password.charAt(i);
            if(specialChars.contains(Character.toString(c))){
                return true;
            }
        }

        return false;
    }

    public static synchronized PasswordValidator getInstance() {
		if (instance == null) {
			instance = new PasswordValidator();
		}
		return instance;
	}
    
}
