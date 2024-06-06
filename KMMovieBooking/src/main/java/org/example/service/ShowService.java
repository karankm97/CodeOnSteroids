package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.UnableToCreateShowException;
import org.example.model.Movie;
import org.example.model.Screen;
import org.example.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowService {
    private Map<String, Show> shows;

    public ShowService() {
        shows = new HashMap<>();
    }

    public Show getShow(String showId) {
        if(!shows.containsKey(showId)) {
            throw new NotFoundException();
        }


        return shows.get(showId);
    }

    public Show createShow(Movie movie, Screen screen, Date startTime, Integer duration) {
        if(!canCreateShow()) {
            throw new UnableToCreateShowException();
        }
        String showId = UUID.randomUUID().toString();
        Show newShow = new Show(showId, movie, screen, startTime, duration);
        shows.put(showId, newShow);
        //TODO: Screen can have list of shows?
        return newShow;
    }

    private boolean canCreateShow() {
        return true;
    }
}
