package com.example.smarthome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    void testSetStationValid() {
        Radio radio = new Radio();
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetVolumeValid() {
        Radio radio = new Radio();
        radio.setVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void testSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testNextWrapAround() {
        Radio radio = new Radio();
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextNormal() {
        Radio radio = new Radio();
        radio.setStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void testPrevWrapAround() {
        Radio radio = new Radio();
        radio.setStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testPrevNormal() {
        Radio radio = new Radio();
        radio.setStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolumeAtMax() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeNormal() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeAtMin() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeNormal() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }
}