package newfeatures;


import java.util.Optional;

public class MyOptional {

    public static void issue() {
        String[] arr = new String[10];
        String i5LowerCase = arr[4].toLowerCase();
        System.out.println(i5LowerCase);
    }

    public static void optionalFeature() {
        String[] strArr = new String[10];
        Optional<String> unConfirmed = Optional.ofNullable(strArr[5]);


        if(unConfirmed.isPresent()) {
            System.out.println("Its present: " + strArr[5]);
        } else {
            System.out.println("Its not present: " + strArr[5]);
        }

    }

    public static void main(String args[]) {

        //MyOptional.issue();
        MyOptional.optionalFeature();

    }
}
