package print;

import domain.*;
import exceptions.EmptyJobsSet;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class JobsController {

    @PostMapping("/jobs")
    public List<User> saveJobs(@RequestBody Jobs jobs)  {

        if (jobs.getJob().size() < 1) {
            throw new EmptyJobsSet();
        }

        Map<String, User> users = new HashMap<>();

        Session session = DBSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        for (Job job : jobs.getJob()) {
            if (session.get(Job.class, job.getId()) == null) {
                User user = (User) session.get(User.class, job.getUser());
                if (user == null) {
                    user = new User(job.getUser(), job.getAmount());
                }

                job.setUserRef(user);

                user.addAmount(job.getAmount());
                session.save(user);
                session.save(job);

                if (!users.containsKey(user.getName())) {
                    users.put(user.getName(), user);
                }
            }
        }

        session.getTransaction().commit();
        session.close();

        return users.values().stream().collect(Collectors.toList());
    }
    @GetMapping("/devices")
    public List<Device> devices() {
        List<Device> devices = new ArrayList<>();

        Session session = DBSessionFactory.getSessionFactory().openSession();
        String hql = "select jb.device, jb.type, sum(jb.amount) " +
                "from Job as jb group by jb.device, jb.type";

        List<?> list = session.createQuery(hql).list();

        for(int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            String name = (String)row[0];
            Type type = (Type)row[1];
            int amount = (int)(long)row[2];
            devices.add(new Device(name, type, amount));
        }

        session.close();

        return devices;
    }

}
