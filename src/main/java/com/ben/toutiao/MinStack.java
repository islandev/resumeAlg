package com.ben.toutiao;

import java.util.Stack;

public class MinStack {

  private Stack<Comparable> normalStack = new Stack<>();
  private Stack<Comparable> minStack = new Stack<>();
  private Comparable minEl;


  void push(Comparable val) {
    if (normalStack.empty()) {
      minEl = val;
      minStack.push(val);
    } else {
      if (minEl.compareTo(val) == 1) {
        minStack.push(val);
      }
    }
    normalStack.push(val);
  }

  Comparable pop() {
    Comparable norm = normalStack.pop();
    if (minEl.compareTo(norm) != -1) {
      minEl = minStack.pop();
    }
    return norm;
  }

  Comparable getMinEl() {
    return minEl;
  }


}
