package util;

public class TestBot {
    private final String login;
    private final String password;

    public TestBot(final String login,
                   final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
