import ru.vasilyev.restaurant.dataBaseConnection.ConnectionManager;
import ru.vasilyev.restaurant.dataBaseConnection.ConnectionManagerImpl;
import ru.vasilyev.restaurant.util.SQLInit;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();
        SQLInit.initScheme(connectionManager);
        SQLInit.initData(connectionManager);
    }
}
