package unit7.facade;

public class Facade {

    public String getInfo(SourceType source, ContentType content) {
        String result = null; // Результирующая переменная

        // Определение нужного источника информации
        switch (source) {
            case SERVER:
                ServerHelper serverHelper = new ServerHelper();

                // Определение типа требуемого контента
                switch (content) {
                    case NUMBER:
                        result = serverHelper.getUserNumber();
                        break;
                    case NAME:
                        result = serverHelper.getUserName();
                        break;
                }
                break;
            case DB:
                DBHelper dbHelper = new DBHelper();
                switch (content) {
                    case NUMBER:
                        result = dbHelper.getUserNumber();
                        break;
                    case NAME:
                        result = dbHelper.getUserName();
                        break;
                }
                break;
        }
        return result;
    }


    // Перечисления типов источников и контента
    public static enum SourceType {
        SERVER, DB
    }

    public static enum ContentType {
        NAME, NUMBER
    }


}
