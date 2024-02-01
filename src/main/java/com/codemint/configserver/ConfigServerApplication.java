package com.codemint.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    @Controller
    @ResponseBody
    class ConfigurationHttpController {
        private ConfigurationRepository configurationRepository;

          ConfigurationHttpController(ConfigurationRepository configurationRepository) {
            this.configurationRepository = configurationRepository;
        }

        @GetMapping("/configurations")
        Iterable<Configuration> configurations(Iterable<String> ids) {
            return this.configurationRepository.findAllById(ids);
        }
    }

    interface ConfigurationRepository extends CrudRepository<Configuration, String> {
    }

    public record Configuration(@Id String Name, String configuration) {
    }
}
