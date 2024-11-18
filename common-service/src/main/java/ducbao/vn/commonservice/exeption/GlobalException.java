package ducbao.vn.commonservice.exeption;

import ducbao.vn.commonservice.model.APIResponse;
import ducbao.vn.commonservice.model.AppException;
import ducbao.vn.commonservice.model.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<APIResponse> handleAppException(AppException e) {
        ErrorCode errorResponse = e.getErrorCode();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(errorResponse.getCode());
        apiResponse.setMessage(errorResponse.getMessage());
        System.out.println("Handling AppException: " + e.getMessage());
        return ResponseEntity.status(errorResponse.getCode()).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleException(Exception e) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
        return ResponseEntity.status(ErrorCode.UNCATEGORIZED.getCode()).body(apiResponse);
    }
}

