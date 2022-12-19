package com.example.clockshop;

import java.util.ArrayList;
import java.util.List;

public class ClockService {

    private ClockDAOImpl clockDAO = new ClockDAOImpl();

    public ClockService() {
    }

    public clockInterface findClock(int id) {
        return clockDAO.findById(id);
    }

    public void saveClock(clockInterface clock) {
        clockDAO.save(clock);
    }

    public void deleteClock(clockInterface clock) {
        clockDAO.delete(clock);
    }

    public void updateClock(clockInterface clock) {
        clockDAO.update(clock);
    }

    public List<clockInterface> findAllClocks() {
        return clockDAO.findAll();
    }

}