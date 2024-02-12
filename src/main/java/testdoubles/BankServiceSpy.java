package testdoubles;
import com.example.BankService;
public class BankServiceSpy implements BankService {

    private boolean payMethodCalled = false;
    private boolean throwException = false;

    @Override
    public void pay(String id, double amount) {
        payMethodCalled = true;
        if (throwException) {
            throw new RuntimeException("Failed to process payment");
        }
    }

    public boolean isPayMethodCalled() {
        return payMethodCalled;
    }

    public void setThrowException(boolean throwException) {
        this.throwException = throwException;
    }
}
