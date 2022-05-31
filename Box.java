import java.util.ArrayList;

public class Box<T> {
    private float fruitWeight;
    private ArrayList <T> fruits = new ArrayList<>();

    public <T> Box (float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruits (T fruit) {
        fruits.add(fruit);
    }
    public float getBoxWeight (){
        return fruits.size() * fruitWeight;
    }
    public boolean compareBoxes (Box <?> box) {
        return box.getBoxWeight() == this.getBoxWeight();
    }
    public void shareFruits (Box <T> box) {
        System.out.println("Коробка №1 до пересыпки : " + fruits.size() + "шт " + "Весом : " + this.getBoxWeight());
        System.out.println("Коробка №2 до пересыпки : " + box.getFruits().size() + "шт " + "Весом : " + box.getBoxWeight());
        fruits.addAll(box.fruits);
        box.fruits.clear();
        System.out.println("Коробка №1 после пересыпки : " + fruits.size() + "шт " + "Весом : " + this.getBoxWeight());
        System.out.println("Коробка №2 после пересыпки : " + box.getFruits().size() + "шт " + "Весом : " + box.getBoxWeight());

    }
}
