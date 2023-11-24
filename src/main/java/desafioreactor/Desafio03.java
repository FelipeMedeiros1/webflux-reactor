package desafioreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Desafio03 {

    /*
        Verifica se o usuário passado é válido, caso seja retorna void, caso contrário deve disparar uma exception
        (para esse desafio vamos considerar que o usuário é válido quando ele tem uma senha com mais de 8 caracteres)
         */
    public Mono<Void> userIsValid(final User user) {
        return Mono.fromRunnable(() -> {
            if (user == null || user.password() == null || user.password().length() <= 8) {
                throw new UserValidationException("Usuário inválido");
            }
        });
    }

    // Exceção customizada para validação de usuário
    static class UserValidationException extends RuntimeException {
        public UserValidationException(String message) {
            super(message);
        }

    }
}
