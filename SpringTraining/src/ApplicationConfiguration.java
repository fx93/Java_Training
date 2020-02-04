import com.training.salesmanager.repository.EmployeeRepository;
import com.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.training.salesmanager.service.EmployeeService;
import com.training.salesmanager.service.EmployeeServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.training")
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Bean(name = "employeeService")
    @Scope("prototype")
    public EmployeeService getEmployeeService(){

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        //employeeService.setEmployeeRepository(getEmployeeRepository());

        return employeeService;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /*@Bean(name = "employeeRepository")
    public EmployeeRepository getEmployeeRepository(){
        return new HibernateEmployeeRepositoryImpl();
    }*/
}
