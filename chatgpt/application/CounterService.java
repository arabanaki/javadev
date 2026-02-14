package chatgpt.application;

import chatgpt.domain.CounterModel;

public class CounterService {
    private final CounterModel counterModel;

    public CounterService(int min, int max) {
        this.counterModel = new CounterModel(min, max);
    }

    public int startFromBeginning() {
        counterModel.reset();
        return counterModel.getValue();
    }

    public int moveToNextValue() {
        counterModel.next();
        return counterModel.getValue();
    }
}
