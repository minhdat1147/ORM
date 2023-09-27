package fa.training.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidatorHibernate {
	public <T> boolean isValidInput(T object){
		// Create ValidatorFactory which returns validator
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        
        // It validates bean instances
        Validator validator = validatorFactory.getValidator();
        
        // Validate bean
	    Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
	    
	    // Show errors
	    if (constraintViolations.size() > 0) {
	        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
	            System.err.println(constraintViolation.getMessage());
	        }
	        return false;
	    } else {
	        System.out.println("Valid Object");
	        return true;
	    }
	}
}
