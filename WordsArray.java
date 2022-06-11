import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordsArray {
    private ArrayList <String> arrayWords;

    public WordsArray(ArrayList<String> arrayWords) {
        this.arrayWords = arrayWords;
    }
    // создадим hashmap для перебора слов и присвоения уникальных значений
    private HashMap <String, Integer> getMapWords (ArrayList <String> arrayWords){
        HashMap <String,Integer> mapWords = new HashMap<>();
        for (String str : arrayWords) {
            if(mapWords.containsKey(str)) {
                mapWords.put(str, mapWords.get(str) + 1);
            } else {
                mapWords.put(str, 1);
            }
            System.out.println("в мапу добавили слово " + str + " , кол-во " + mapWords.get(str));
        }
        printMap(mapWords);
        return mapWords;

        /* тоже самое что и сверху for (int i =0; i < arrayWords.toArray().length; i++) {
            if(mapWords.containsKey(arrayWords.get(i))) {
                mapWords.put(arrayWords.get(i), mapWords.get(arrayWords.get(i)) + 1);
            } else {
                mapWords.put(arrayWords.get(i), 1);
            }*/
    }

    // проверим созданный ранее hashmap и выведем уникальные значения
    public void checkArray () {
        HashMap <String,Integer> mapWords = getMapWords(arrayWords);
        for (Map.Entry entry : mapWords.entrySet()) {
            if(entry.getValue().equals(1)) {
                System.out.println(entry.getKey());
            }
            
        }
    }

    public void printMap (HashMap <String,Integer> mapWords) {
        System.out.println("ПЕЧАТАЕМ HASH MAP");
        for (Map.Entry entry : mapWords.entrySet()) {
            //if(entry.getValue().equals(1)) {
                System.out.println(entry.getKey() + " встречается - " + entry.getValue() + " раз");
            //}

        }
        System.out.println("*********");
        System.out.println("Выведем уникальные значения : ");
    }
}
