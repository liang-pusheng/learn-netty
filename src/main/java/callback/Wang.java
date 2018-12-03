package callback;

public class Wang implements Callback {

    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(final String question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();

        play();
    }

    public void play() {
        System.out.println("wo wan qu l");
    }

    @Override
    public void solve(String result) {
        System.out.println("li tell wang the answer is:" + result);
    }
}
