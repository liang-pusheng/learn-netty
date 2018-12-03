package callback;

public class Li {

    public void executeMessage(Callback callback, String question) {
        System.out.println("小王问的问题:" + question);

        for (int i = 0; i < 10000; i++) {

        }

        String result = "2";

        callback.solve(result);
    }

    public static void main(String[] args) {

    }
}
