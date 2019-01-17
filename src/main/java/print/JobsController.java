package print;

import domain.Job;
import domain.Jobs;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobsController {
    //@RequestParam(value="name", defaultValue="World") String name
    @PostMapping("/jobs")
    public String saveJobs(@RequestBody Job job) {
        return job.getDevice();
    }
}
