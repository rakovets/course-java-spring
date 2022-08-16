package by.rakovets.course.java.spring.boot.web_service.repository;

import by.rakovets.course.java.spring.boot.web_service.model.Pet;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Repository
public class PetRepository {
    public Pet getPetById(Long id) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(new ClassPathResource("database").getInputStream()))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] split = line.split(";");
                if (Long.parseLong(split[0]) == id) {
                    return new Pet(Long.parseLong(split[0]), split[1], split[2], split[3], split[4], split[5]);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
