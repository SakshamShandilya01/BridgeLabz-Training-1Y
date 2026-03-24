package com.gla.objectandclasses.Level2;

class MovieTicket {

    String movieName;
    int seatNumber;
    double price;

    public void bookTicket(String name, int seat, double price) {
        this.movieName = name;
        this.seatNumber = seat;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();

        t1.bookTicket("Avengers", 12, 250);
        t1.displayDetails();
    }
}

