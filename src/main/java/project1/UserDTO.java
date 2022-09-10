package project1;

import java.sql.Timestamp;

public record UserDTO(Integer id, Timestamp birthday, String name, String email) {
}
