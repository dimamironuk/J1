import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            Category laptops = new Category("Ноутбуки");
            Category smartphones = new Category("Смартфони");

            categoryRepository.saveAll(List.of(laptops, smartphones));
        }

        if (productRepository.count() == 0) {
            Product macbook = new Product("MacBook Air", categoryRepository.findByName("Ноутбуки"));
            Product iphone = new Product("iPhone 15", categoryRepository.findByName("Смартфони"));

            productRepository.saveAll(List.of(macbook, iphone));
        }

        System.out.println("Seed дані успішно додані!");
    }
}
