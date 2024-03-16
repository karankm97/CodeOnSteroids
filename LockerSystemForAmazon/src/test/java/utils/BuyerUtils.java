package utils;

import org.example.model.Buyer;
import org.example.model.Contact;

import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;

public class BuyerUtils {
    public static Buyer randomBuyer() {
        return new Buyer(new Contact(randomString(), randomEmail()));
    }
}
