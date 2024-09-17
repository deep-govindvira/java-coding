package org.example.dp.facade;

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("DVD Player is stopped.");
    }

    public void off() {
        System.out.println("DVD Player is off.");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier is on.");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier is off.");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void wideScreenMode() {
        System.out.println("Projector is in widescreen mode.");
    }

    public void off() {
        System.out.println("Projector is off.");
    }
}

class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
    }
}


public class FacadePatternDemo {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}
