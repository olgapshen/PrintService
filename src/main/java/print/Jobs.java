package print;

import domain.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Jobs {
    //@RequestParam(value="name", defaultValue="World") String name
    @GetMapping("/jobs")
    public Response greeting() {
        return new Response();
    }
}
