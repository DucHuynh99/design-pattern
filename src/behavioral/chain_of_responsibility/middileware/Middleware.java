package behavioral.chain_of_responsibility.middileware;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware head, Middleware... chain) {
        Middleware current = head;
        for (Middleware node : chain) {
            current.next = node;
            current = node;
        }
        return head;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
