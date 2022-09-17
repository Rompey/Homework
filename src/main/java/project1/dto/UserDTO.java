package project1.dto;

import java.sql.Timestamp;

public record UserDTO(Timestamp birthday, String name, String email) {
}
