package maven.exercise;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

/**
 *  https://commons.apache.org/proper/commons-lang/article3_0.html
 * @author y,kawakami
 *
 */
public class SampleValidator implements SmartValidator {

	public boolean supports(Class<?> clazz) {
		return SampleForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		SampleForm form = (SampleForm)target;
		
		// XXX commons-langとcommons-lang3で動作が異なる。
		if(StringUtils.isAlpha(form.getParam1())) {
			errors.rejectValue("param1", "errorNotAlphabet");
		}
	}

	public void validate(Object target, Errors errors, Object... validationHints) {
		// TODO Auto-generated method stub
		
	}
	
}
