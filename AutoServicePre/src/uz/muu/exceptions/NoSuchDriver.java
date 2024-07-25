//package uz.muu.exceptions;
//
//public class NoSuchDriver extends Exception {
//    public NoSuchDriver(String message) {
//        super(message);
//    }
//}

package uz.muu.exceptions;

public class NoSuchDriver extends Exception {
    public NoSuchDriver() {
        super("Driver not found.");
    }

    public NoSuchDriver(String message) {
        super(message);
    }
}
