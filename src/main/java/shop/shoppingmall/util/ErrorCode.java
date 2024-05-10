package shop.shoppingmall.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND(404, "The requested resource was not found"),
    INVALID_INPUT(400, "The input provided is invalid"),
    INTERNAL_SERVER_ERROR(500, "An unexpected error occurred on the server");

    private final int status;

    private final String message;
}
