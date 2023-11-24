package desafioreactor;

public record User(Long id,
                   String name,
                   String email,
                   String password,
                   Boolean isAdmin) {
    public String password() {
        return password;
    }

}