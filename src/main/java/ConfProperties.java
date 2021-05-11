import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            //todo изменил на считывание файла из другого места, раньше лежал файл в test/resources
            //todo возможно изменить, т.к. захардкожен путь
            fileInputStream = new FileInputStream("C:\\Users\\dinod\\IdeaProjects\\TPO3\\conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}