package com.example.photographinsta.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void newUsuario() {
        Assertions.assertNotNull(new User("gabriel", "senha"));
    }

    @Test
    public void novoUsuario_usernameNullShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "senha"));
    }

    @Test
    public void novoUsuario_passwordNullShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("Gabriel", null));
    }

}
