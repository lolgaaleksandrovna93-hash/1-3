package com.example.smarthome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void nextWrapsAroundFrom9To0() {
        Radio radio = new Radio();
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextIncrementsNormally() {
        Radio radio = new Radio();
        radio.setStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void prevWrapsAroundFrom0To9() {
        Radio radio = new Radio();
        radio.setStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void prevDecrementsNormally() {
        Radio radio = new Radio();
        radio.setStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void setStationValid() {
        Radio radio = new Radio();
        radio.setStation(7);
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    void setStationInvalidIgnored() {
        Radio radio = new Radio();
        radio.setStation(10); // вне диапазона
        assertEquals(0, radio.getCurrentStation()); // по умолчанию 0
    }

    @Test
    void increaseVolumeStopsAt100() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeWorksNormally() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeStopsAt0() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolumeWorksNormally() {
        Radio radio = new Radio();
        radio.setVolume(30);
        radio.decreaseVolume();
        assertEquals(29, radio.getCurrentVolume());
    }

    @Test
    void setVolumeValid() {
        Radio radio = new Radio();
        radio.setVolume(75);
        assertEquals(75, radio.getCurrentVolume());
    }

    @Test
    void setVolumeInvalidIgnored() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getCurrentVolume()); // по умолчанию 0
    }
}