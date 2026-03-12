package co.edu.uniquindio.laboratorioCollections.taxiRequestPlatform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    private String code;
    private String location;

    @Override
    public String toString() {
        return "Request{" +
                "code='" + code + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}