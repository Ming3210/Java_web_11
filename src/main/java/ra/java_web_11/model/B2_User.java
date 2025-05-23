package ra.java_web_11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.java_web_11.validate.EmailValidator;
import ra.java_web_11.validate.PasswordValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class B2_User {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String name;

    @EmailValidator(message = "Email không đúng định dạng")

    private String email;

    @PasswordValidator(message = "Mật khẩu phải chứa ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường và số")
    private String password;
}
