package ra.java_web_11.controller;

import ra.java_web_11.model.ReviewForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public String showReviewForm(Model model) {
        model.addAttribute("reviewForm", new ReviewForm());
        return "review-form";
    }

    @PostMapping("/review")
    public String processReview(@Valid @ModelAttribute("reviewForm") ReviewForm form,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            return "review-form";
        }
        model.addAttribute("message", "Cảm ơn bạn đã đánh giá!");
        return "review-success";
    }
}
