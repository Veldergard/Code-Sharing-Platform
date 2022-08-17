package platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Code {
    private String code;
    private LocalDateTime date;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Code() {
        date = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date.format(formatter);
    }

    public void setDate(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }
}
