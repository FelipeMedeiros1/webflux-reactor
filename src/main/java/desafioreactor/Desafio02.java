package desafioreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Desafio02 {
    /*
    Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */
    public Mono<Long> countAdmins(final List<User> users){
        return Mono.justOrEmpty(users)
                .flatMapIterable(usersList -> usersList)
                .filter(User::isAdmin)
                .count();
    }
}
