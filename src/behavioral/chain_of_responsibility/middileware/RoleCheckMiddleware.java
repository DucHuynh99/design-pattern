package behavioral.chain_of_responsibility.middileware;

public class RoleCheckMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hi, Admin!");
            return true;
        }
        System.out.println("Hello, User!");
        return checkNext(email, password);
    }
}
