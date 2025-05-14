package com.grepp.moodlink.app.controller.web.home;
import com.grepp.moodlink.app.model.home.HomeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping
    public String mainPage(Model model) {
        List<String> thumbnail = homeService.showContent();
        List<String> people = homeService.findPeople();
        List<String> title = homeService.findTitle();
//        List<String> description = homeService.findDescription();

        model.addAttribute("thumbnail",thumbnail);
        model.addAttribute("people",people);
        model.addAttribute("title",title);
//        model.addAttribute("description",description);

        return "/home/mainPage";
    }

    @GetMapping("/worldcup")
    public String worldcupPage(Model model) {
        return "/home/worldcup";
    }

    @GetMapping("/fortune")
    @ResponseBody
    public String getFortune() {
        // 간단한 예시. 실제로는 랜덤 운세 등을 줄 수 있음
        return "오늘은 좋은 일이 생길 거예요! 😊";
    }
}
