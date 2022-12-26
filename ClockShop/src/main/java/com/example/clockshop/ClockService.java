package com.example.clockshop;

public class ClockService {

    private ClockDAOImpl clockDAO = new ClockDAOImpl();

    public ClockService() {
    }

    public ClockShopEnt findClock(int id) {
        return clockDAO.findById(id);
    }

    public void saveClock(ClockShopEnt clock) {
        clockDAO.save(clock);
    }

    /*public void deleteClock(int id) {
        clockDAO.delete(id);
    }

    public void updateClock(int id) {
        clockDAO.update(id);
    }*/

    /*public List<ClockShop> findAllClocks() {
        return clockDAO.findAll();
    }*/

}