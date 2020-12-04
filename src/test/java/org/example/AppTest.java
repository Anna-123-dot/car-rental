package org.example;

import dao.CarDao;
import dao.PresentRentalsDao;
import model.Car;
import model.PresentRentals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAddCar() {
        //given
        CarDao carDao = new CarDao();
        Car car = new Car("Ford", "Focus", "black", "GD12347", false);
        //when
        carDao.add(car);
        // then
        Assertions.assertEquals(car, carDao.findById(carDao.findAll().size() + 1));
    }

    @Test
    public void shouldRemoveCar() {
        //given
        CarDao carDao = new CarDao();
        int id = 7;
        //when
        Car carX = carDao.findById(id);
        carDao.remove(carX);
        //then
        assertFalse(carDao.findAll().contains(carX));
    }

    @Test
    public void shouldUpdateRecordOfPresentRental() {
        //given
        PresentRentalsDao presentRentalsDao = new PresentRentalsDao();
        PresentRentals presentRentalsToBeChange = presentRentalsDao.findById(1);
        //when
        presentRentalsToBeChange.setPlannedReturnDate(LocalDate.of(2021, 1, 1));
        presentRentalsDao.update(presentRentalsToBeChange);
        //then
        assertEquals(LocalDate.of(2021, 1, 1), presentRentalsDao.findById(1).getPlannedReturnDate());

    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
