package tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;


public class Task2 {
    public static void main(String[] args){
        String ipReader = null;

        try {
            ipReader = Jsoup.connect("https://api.ipify.org/?format=json")
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных по URL");
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        IP catcher = parser.fromJson(ipReader, IP.class);//переводим Json в объект
        ipInFile(catcher);//функция записи в файл
    }

    private static void ipInFile(IP catcher){
        try (FileWriter writeIp = new FileWriter("ipBarn.txt");) {//отлавливаем исключения
            writeIp.write("ip ползователя:" + catcher.getIp());
        } catch (IOException e){
            System.out.print("Возникли проблемы с записью данных в файл");
            e.printStackTrace();
        }
    }
}
