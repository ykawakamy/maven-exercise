package maven.exercise;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class SampleValidatorTest {

	SampleValidator testee = new SampleValidator();
	/**
	 *  空文字がセットされた場合
	 */
	@Test
	public void test_EmptyString() {
		SampleForm form = new SampleForm();;
		form.setParam1("");
		
		Errors errors = new BeanPropertyBindingResult(form, "xxx");
		
		testee.validate(form , errors );
		
		assertThat( errors.getErrorCount(), is( 1));
	}

	/**
	 *  Nullがセットされた場合
	 */
	@Test
	public void test_Null() {
		SampleForm form = new SampleForm();;
		form.setParam1(null);
		
		Errors errors = new BeanPropertyBindingResult(form, "xxx");
		
		testee.validate(form , errors );
		
		assertThat( errors.getErrorCount(), is( 0));
	}

}
