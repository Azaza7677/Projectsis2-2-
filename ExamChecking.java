class ExamChecking extends Thread {
    private int examSheets = 500;
    private int sheetsToCheck;
    private int maxIterations;
    private int checkedSheets = 0;

    public ExamChecking(int sheetsToCheck, int maxIterations) {
        this.sheetsToCheck = sheetsToCheck;
        this.maxIterations = maxIterations;
    }

    @Override
    public void run() {
        while (examSheets > 0) {
            if (examSheets <= sheetsToCheck) {
                sheetsToCheck = examSheets;
            }

            examSheets -= sheetsToCheck;
            checkedSheets++;

            System.out.println(Thread.currentThread().getName() + " checked " + sheetsToCheck + " sheets. Remaining: " + examSheets);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (checkedSheets >= maxIterations) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ExamChecking m = new ExamChecking(50, 6);
        ExamChecking m2 = new ExamChecking(50, 4);

        m.setName("Alibek");
        m2.setName("Dana");

        m.start();
        m2.start();
    }
}


