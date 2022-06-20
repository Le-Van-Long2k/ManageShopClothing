package longlevan2k.com.example.manageshopclothing.model;

public class ResponseEntity {
    String HttpStatus;
    int HttpStatusCode;

    public ResponseEntity(String httpStatus, int httpStatusCode) {
        HttpStatus = httpStatus;
        HttpStatusCode = httpStatusCode;
    }

    public String getHttpStatus() {
        return HttpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        HttpStatus = httpStatus;
    }

    public int getHttpStatusCode() {
        return HttpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        HttpStatusCode = httpStatusCode;
    }
}
