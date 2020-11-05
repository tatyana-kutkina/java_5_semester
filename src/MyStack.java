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
            int n = data.size();
            return data.get(n-1);
        }
    }

    @Override
    public Object pop() {
        if (this.empty()) {
            return null;
        } else {
            int n = data.size();
            return data.remove(n-1);
        }
    }

    @Override
    public Object push(Object element) {
        int n = data.size();
        data.add(n, element);
        return data.get(n);
    }

    @Override
    public int size() {
        return data.size();
    }

}