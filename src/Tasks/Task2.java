package Tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;


public class Task2 {
    public static void main(String[] args) throws IOException {
        String ipReader = Jsoup.connect("https://api.ipify.org/?format=json") //подключаемся по ссылке и получаем данные
                .ignoreContentType(true).execute().body();

        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в

        IP catcher = parser.fromJson(ipReader, IP.class);//переводим Json в объект
        ipInFile(catcher);//функция записи в файл

    }

    private static void ipInFile(IP catcher){
        try (FileWriter writeIp = new FileWriter("ipBarn.txt")){//отлавливаем исключения
            writeIp.write("ip ползователя:" + catcher.getIp());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
