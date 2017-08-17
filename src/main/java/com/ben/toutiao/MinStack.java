package com.ben.toutiao;

import java.util.Comparator;
import java.util.Stack;

public class MinStack {

  private Stack<Comparable> normalStack = new Stack<>();

  private Comparable minEl;


  void push(Comparable val) {
    if (normalStack.empty()) {
      minEl = val;
    } else {
      minEl = minEl.compareTo(val)>0 ? val : minEl;
    }
    normalStack.push(val);
  }

  void pop(){
    Comparable pop = normalStack.pop();
  }


}
