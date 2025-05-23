package ra.java_web_11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.java_web_11.validate.PhoneNumberValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class B1_User {
    @NotNull(message = "ID không được để trống")
    private Long id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(min = 5, max = 100, message = "Địa chỉ phải từ 5 đến 100 ký tự")
    private String address;

    @PhoneNumberValidator
    private String phoneNumber;
}
