package jp.co.commerce21.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.commerce21.dao.MemberDao;
import jp.co.commerce21.entity.Member;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Member member = memberDao.findByEmailText(value);
		if (member == null) {
			return true;
		} else {
			return false;
		}
	}
}
