package com.example.demo;

import java.sql.Timestamp;

public record UserDTO(Integer id, Timestamp birthday, String name, String email) {
}
