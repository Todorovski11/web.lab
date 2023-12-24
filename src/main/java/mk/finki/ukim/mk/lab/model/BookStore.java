package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
public class BookStore {
    private static Random randomIdGenerator = new Random();
    private Long id;
    private String name;
    private String city;
    private String address;

    public BookStore(String name, String city, String address) {
        this.id = randomIdGenerator.nextLong(1000);
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
