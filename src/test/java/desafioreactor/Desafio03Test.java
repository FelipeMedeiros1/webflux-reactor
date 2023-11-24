package desafioreactor;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Locale;
public class Desafio03Test {
    private Desafio03 desafio03;
    private final Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeEach
    void setup(){
        desafio03 = new Desafio03();
    }

    @Test
    void invalidUser(){
        StepVerifier.create(desafio03.userIsValid(new User(1L, faker.name().name(), faker.internet().emailAddress(),
                        faker.lorem().characters(0, 8), faker.bool().bool())))
                .verifyError();
    }

    @Test
    void validUser(){
        StepVerifier.create(desafio03.userIsValid(new User(1L, faker.name().name(), faker.internet().emailAddress(),
                        faker.lorem().characters(8, 255), faker.bool().bool())))
                .verifyComplete();
    }

    @AfterEach
    void teardown(){
        desafio03 = null;
    }


}
