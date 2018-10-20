package amors.dto;

public class AuthResponse {
    private String token;
    private boolean error;
    private String message;

    public AuthResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public AuthResponse(String token, boolean error, String message) {
        this.token = token;
        this.error = error;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
