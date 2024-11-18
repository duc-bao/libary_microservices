package ducbao.vn.commonservice.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    // Not Found
    ID_NOT_FOUND(1001, "NOT FOUND BY ID",HttpStatus.NOT_FOUND),


    // Interval
    UNCATEGORIZED(1002, "UNCATEGORIZED ERROR",HttpStatus.INTERNAL_SERVER_ERROR),
    ;
    int code;
    String message;
    HttpStatus status;

    ErrorCode(int code, String message, HttpStatus status) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
