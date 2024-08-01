package org.cloaiza.core.dtos;

import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HttpResponseDTO {
    private int statusCode = HttpResponseStatus.OK.code();
    private boolean success = true;
    private Object data = null;
    private String message = "";

    public HttpResponseDTO(String message) {
        this.message = message;
    }

    public HttpResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;

        if (!success) {
            this.statusCode = HttpResponseStatus.INTERNAL_SERVER_ERROR.code();
        }
    }

    public HttpResponseDTO(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
