import java.util.HashMap;
import java.util.Map;

public class WebsiteCredentials {
    private Map<String ,String> Credentials = new HashMap<String, String>();

    public void setLogin(String login) {
        Credentials.put("Login", login);
    }

    public void setPassword(String password) {
        Credentials.put("Password", password);
    }

    public Map<String, String> getCredentials() {
        return Credentials;
    }
}
