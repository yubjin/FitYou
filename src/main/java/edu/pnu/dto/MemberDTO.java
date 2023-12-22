package edu.pnu.dto;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import edu.pnu.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String username;
	private String pwd;
	private int age;
	private int cusNum;
	private String styleInfo;
	private Role role;

	public void encodingPassword(PasswordEncoder passwordEncoder) {
		if (StringUtils.isEmpty(pwd)) {
			return;
		}
		pwd = passwordEncoder.encode(pwd);
	}
}
