package kr.ac.poly.Controller;


import kr.ad.poly.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;
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

    @GetMapping({"/ex2"})
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
        model.addAttribute("List", list);
    }

}
