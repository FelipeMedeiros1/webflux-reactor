package desafioreactor;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Desafio01Test {

    private Desafio01 desafio01;
    private final Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeEach
    void setup(){
        desafio01 = new Desafio01();
    }

    @Test
    void incTest(){
        var numbers = Stream.generate(() -> faker.number().randomNumber())
                .limit(faker.number().randomDigitNotZero())
                .toList();
        StepVerifier.create(desafio01.inc(numbers))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(actual -> true)
                .consumeRecordedWith(actual ->{
                    var actualList = new ArrayList<>(actual);
                    IntStream.range(0, actual.size())
                            .forEach(i -> assertEquals(actualList.get(i), numbers.get(i) + 1L));
                })
                .verifyComplete();
    }

    @AfterEach
    void tearDown(){
        desafio01 = null;
    }

}