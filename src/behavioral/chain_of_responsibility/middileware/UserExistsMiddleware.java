package behavioral.chain_of_responsibility.middileware;

import behavioral.chain_of_responsibility.server.Server;

public class UserExistsMiddleware extends Middleware {
    private final Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasPassword(email)) {
            System.out.println("Email not found");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Incorrect password");
            return false;
        }
        return checkNext(email, password);
    }
}
