package com.hubberspot.mockito.testdoubles.dummy;

public class DummyEmailService implements EmailService{
    @Override
    public void sendEmail(String message) {
        System.out.println("Executinhg in Test run.. Dummy Email sent with message"+message);
    }
}
