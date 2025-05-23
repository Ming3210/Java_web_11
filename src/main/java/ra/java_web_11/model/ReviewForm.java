package ra.java_web_11.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
public class ReviewForm {

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Tên không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Vui lòng chọn mức đánh giá")
    @Min(value = 1, message = "Đánh giá tối thiểu là 1 sao")
    @Max(value = 5, message = "Đánh giá tối đa là 5 sao")
    private Integer rating;

    @Size(max = 200, message = "Bình luận không được vượt quá 200 ký tự")
    private String comment;
}
