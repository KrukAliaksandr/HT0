import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mp3Finder {
    static void findAllMp3Audio(File topDirectory, List<File> res){
        //получаем список всех объектов в текущей директории
        File[] list = topDirectory.listFiles();
        //просматриваем все объекты по-очереди
        if (list != null) {
            for (File aList : list) {
                if (aList.isDirectory()) {
                    res.add(aList);
                    //выполняем поиск во вложенных директориях
                    findAllMp3Audio(aList, res);
                }
                //если это файл
                else {
                    if (accept(aList.getName())) {
                        System.out.println(aList);
                        //добавляем текущий объект в список результатов
                        res.add(aList);
                    }
                }
            }
        }
    }
    private static boolean accept(String name) {
        Pattern p = Pattern.compile(".*.mp3.*");
        Matcher m;
        m = p.matcher(name);
        //выполняем проверку
        return m.matches();
    }
}
