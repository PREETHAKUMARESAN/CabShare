package com.example.preethakumaresan.cabshare;

/**
 * Created by PREETHA KUMARESAN on 06-09-2016.
 */
public class cabdetails
{
    private String destination;
        private String date;
        private String time;

        public cabdetails(String destination, String date, String time) {
            this.destination = destination;
            this.date = date;
            this.time = time;
        }

        public String getDestination() {
            return this.destination;
        }

        public String getDate() {
            return this.date;
        }

        public String getTime() {
            return this.time;
        }
}
