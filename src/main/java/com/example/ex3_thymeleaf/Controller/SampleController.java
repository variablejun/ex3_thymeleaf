package com.example.ex3_thymeleaf.Controller;


import com.example.ex3_thymeleaf.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @GetMapping("/ex1")
    public void ex1(){
        log.info("ex1의 정보......");
    }

    @GetMapping({"/ex2", "/exLink", "/exFormat"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(
                i -> {
                    SampleDTO dto = SampleDTO.builder().sno(i)
                            .first("First..." + i)
                            .last("Last..." + i)
                            .regTime(LocalDateTime.now())
                            .build();
                    return dto;
                }
        ).collect(Collectors.toList());
        model.addAttribute("list", list);
    }

    @GetMapping("exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addAttribute("result", "Success");
        redirectAttributes.addAttribute("dto", dto);
        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void ex3(){
        log.info("ex3() 호출됨");
    }

    @GetMapping("/exLayout")
    public void exLayout1(){
        log.info("exLayout1() 호출됨");
    }
    @GetMapping("/exLayout2")
    public void exLayout2(){
        log.info("exLayout2() 호출됨");
    }
    @GetMapping("/exLayout3")
    public void exLayout3(){
        log.info("exLayout3() 호출됨");
    }
}
