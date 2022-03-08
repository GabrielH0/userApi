package com.example.photographinsta.domain.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import java.time.LocalDate;

@RunWith(JUnit4ClassRunner.class)
public class UserTest {

    private User user;

    @Before
    public void init() {
        user = new UserBuilder("gabriel", "password")
                .withBirthDate(LocalDate.of(1999, 9, 20))
                .withOccupation("Developer")
                .build();
    }

    @Test
    public void newUser() {
        Assertions.assertNotNull(user);
    }

    @Test
    public void newUser_usernameNullShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, user.getPassword(),
                user.getBirthDate(), user.getOccupation()));
    }

    @Test
    public void newUser_passwordNullShouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(user.getUsername(), null,
                user.getBirthDate(), user.getOccupation()));
    }

    @Test
    public void newUser_birthDateNullShoudlPass() {
        Assertions.assertNotNull(new User(user.getUsername(), user.getPassword(),
                null, user.getOccupation()));
    }

    @Test
    public void newUser_birhtDateTooOldShoudlThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new User(user.getUsername(), user.getPassword(),
                LocalDate.of(1800, 1, 1), user.getOccupation()));
    }

    @Test
    public void newUser_birhtDateAfterNowshoudlThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new User(user.getUsername(), user.getPassword(),
                LocalDate.of(LocalDate.now().plusYears(1).getYear(), 1, 1), user.getOccupation()));
    }

}
