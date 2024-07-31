package org.cloaiza.core.dtos;

import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponseDTO {
    private int statusCode = HttpResponseStatus.OK.code();
    private boolean success = true;
    private Object data = null;
    private String message = "";

    public HttpResponseDTO(String message) {
        this.message = message;
    }
}
