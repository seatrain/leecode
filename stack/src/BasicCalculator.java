public class BasicCalculator {

  class MyStack<T> {


    class Node {

      T value;
      Node next;
    }

    private Node head;

    public MyStack() {
    }

    public void push(T c) {
      Node node = new Node();
      node.value = c;

      if (head != null) {
        node.next = head;
      }
      head = node;
    }

    public T pop() {

      Node old = head;
      head = head.next;
      return old.value;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public T top() {
      return head == null ? null : head.value;
    }
  }

  public int calculate(String s) {
    MyStack<Integer> dataStack = new MyStack();
    MyStack<Character> symbolStack = new MyStack();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int num = c - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = (num * 10 + s.charAt(i + 1) - '0');
          i++;
        }
        dataStack.push(num);
      } else if (c == ' ') {
        continue;
      } else if (c == ')') {
        calculateToLeftParenthese(dataStack, symbolStack);
      } else {
        if (c == '(' || symbolStack.isEmpty()) {
          symbolStack.push(c);
          continue;
        }
        if (c == '-' || c == '+') {
          if (symbolStack.top() == '+' || symbolStack.top() == '-') {
            char symbol = symbolStack.pop();
            Integer second = dataStack.pop();
            Integer first = dataStack.pop();
            dataStack.push(calculateWithSymbolsAndIntegers(symbol, first, second));
          }

        }
        symbolStack.push(c);
      }
    }

    calculateNoParenthese(dataStack, symbolStack);
    return dataStack.pop();
  }

  public void calculateToLeftParenthese(MyStack<Integer> dataSymbol, MyStack<Character> symbolStack) {
    while (!symbolStack.isEmpty()) {
      char symbol = symbolStack.pop();
      if (symbol == '(') {
        break;
      } else {
        Integer second = dataSymbol.pop();
        Integer first = dataSymbol.pop();
        dataSymbol.push(calculateWithSymbolsAndIntegers(symbol, first, second));
      }
    }
  }

  public void calculateNoParenthese(MyStack<Integer> ds, MyStack<Character> symbolStack) {
    while (!symbolStack.isEmpty()) {
      char symbol = symbolStack.pop();
      Integer second = ds.pop();
      Integer first = ds.pop();
      ds.push(calculateWithSymbolsAndIntegers(symbol, first, second));
    }
  }

  public Integer calculateWithSymbolsAndIntegers(char symbol, Integer first, Integer second) {
    if (symbol == '+') {
      return first + second;
    } else {
      return first - second;
    }
  }

  public static void main(String[] args) {
    String s = "21+1";
//    String s = "3-2+1";
    BasicCalculator basicCalculator = new BasicCalculator();
    System.out.println(basicCalculator.calculate(s));
  }
}
