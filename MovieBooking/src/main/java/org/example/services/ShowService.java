package org.example.services;

import lombok.NonNull;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.ScreenAlreadyOccupiedException;
import org.example.model.Movie;
import org.example.model.Screen;
import org.example.model.Show;

import java.util.*;

public class ShowService {
    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(@NonNull final String showId) {
        if (!shows.containsKey(showId)) {
            throw new NotFoundException();
        }
        return shows.get(showId);
    }

    public Show createShow(@NonNull final Movie movie, @NonNull final Screen screen, @NonNull final Date startTime,
                           @NonNull final Integer durationInSeconds) {
        if(!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)) {
            throw new ScreenAlreadyOccupiedException();
        }

        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;
    }

    private List<Show> getShowsForScreen(final Screen screen) {
        final List<Show> response = new ArrayList<>();
        for(Show show : shows.values()) {
            if(show.getScreen().equals(screen)) {
                response.add(show);
            }
        }
        return response;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        //TODO: check whether screen is free for the given time or not
        //Screen creation is allowing to add multiple screens with same name
        //to check this get all the shows with given screen and compare if existing screens have overlap with time of new show
        return true;
    }
}
