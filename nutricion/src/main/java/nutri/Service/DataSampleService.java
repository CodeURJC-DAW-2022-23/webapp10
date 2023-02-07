package nutri.Service;


import nutri.Model.User;
import nutri.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataSampleService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {

        this.userRepository.save(new User("ejemplo@yahoo.es","1234"));
        this.userRepository.save(new User("Juan","Perez","5212323Q","ejemploworker@yahoo.es","1234"));
    }

}
