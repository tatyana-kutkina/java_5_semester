import java.util.Stack;

public class MyStack extends Stack {
    private MyList data;

    public MyStack() {
        this.data = new MyList();
    }

    @Override
    public boolean empty() {
        return data.size() == 0;
    }

    @Override
    public Object peek() {
        if (this.empty()) {
            return null;
        } else {
            return data.get(0);
        }
    }

    @Override
    public Object pop() {
        if (this.empty()) {
            return null;
        } else {
            return data.remove(0);
        }
    }

    @Override
    public Object push(Object element) {
        data.add(0, element);
        return data.get(0);
    }

    @Override
    public int size() {
        return data.size();
    }

}