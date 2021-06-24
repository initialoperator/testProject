package com.chrystian.interviews;

//必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
* Given a class named NestedList whose elements are of type "NestedElement" and "NestedElement" can be
* either NestedList again or just SimpleElement.
*
* Implement pair of functions that gets the overall sequence of the input by keep on calling "hasNext()" and "next()"
*
* E.g.
*      input: [1,2,[3,[4,5],6],[7,8],[9],10]
stack:
[ [3..]..7..10 ]
[]
*      10 rounds of "hasNext()" and "next()" should print out numbers from 1 to 10.
*
*  To simplify the question, if the sub-element is not a NestedList, it will be a integer.
*
*  NestedList will contain a list of NestedElements.
*  NestedElement can be a simple Integer or another NestedList.
*/
public class ShowMeBug {
 static class NestedElement {
     private boolean isList;
     private int intElement;
     private NestedList nestedList;

     public boolean isList() {
         return this.isList;
     }

     public int getIntElement() {
         if (isList) {
             throw new UnsupportedOperationException("NestedList cannot be returned as int.");
         } else {
             return this.intElement;
         }
     }

     public NestedList getNestedList() {
         if (!isList) {
             throw new UnsupportedOperationException("Int cannot be returned as NestedList.");
         } else {
             return this.nestedList;
         }
     }

     public NestedElement(int input) {
         this.isList = false;
         this.intElement = input;
     }

     public NestedElement(NestedList nestedList) {
         this.isList = true;
         this.nestedList = nestedList;
     }
 }

 static class NestedList {
     private List<NestedElement> elementList;

     public List<NestedElement> getElementList() {
         return this.elementList;
     }

     public NestedList(List<NestedElement> elementList) {
         this.elementList = elementList;
     }
 }

 private static NestedList getTestInput() {
     NestedElement nestedElement1 = new NestedElement(1);
     NestedElement nestedElement2 = new NestedElement(2);
     NestedElement nestedElement3 = new NestedElement(3);
     NestedElement nestedElement4 = new NestedElement(4);
     NestedElement nestedElement5 = new NestedElement(5);
     NestedElement nestedElement6 = new NestedElement(6);
     NestedElement nestedElement7 = new NestedElement(7);
     NestedElement nestedElement8 = new NestedElement(8);
     NestedElement nestedElement9 = new NestedElement(9);
     NestedElement nestedElement10 = new NestedElement(10);

     NestedElement nestedRange45 = new NestedElement(new NestedList(new LinkedList<NestedElement>() {{
         add(nestedElement4);
         add(nestedElement5);
     }}));

     NestedElement nestedRange78 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement7);
         add(nestedElement8);
     }}));

     NestedElement nestedRange9 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement9);
     }}));

     NestedElement nestedRange36 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement3);
         add(nestedRange45);
         add(nestedElement6);
     }}));

     NestedList testInput = new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement1);
         add(nestedElement2);
         add(nestedRange36);
         add(nestedRange78);
         add(nestedRange9);
         add(nestedElement10);
     }});

     return testInput;
 }

 
 private static NestedList getTestInput2() { //[1,2,[3,[],[4,5],6],[7,8],[9],10]
     NestedElement nestedElement1 = new NestedElement(1);
     NestedElement nestedElement2 = new NestedElement(2);
     NestedElement nestedElement3 = new NestedElement(3);
     NestedElement nestedElement4 = new NestedElement(4);
     NestedElement nestedElement5 = new NestedElement(5);
     NestedElement nestedElement6 = new NestedElement(6);
     NestedElement nestedElement7 = new NestedElement(7);
     NestedElement nestedElement8 = new NestedElement(8);
     NestedElement nestedElement9 = new NestedElement(9);
     NestedElement nestedElement10 = new NestedElement(10);
     
     NestedElement nestedRange34Empty = new NestedElement(new NestedList(new LinkedList<NestedElement>() {{
     }}));
     
     NestedElement nestedRange45 = new NestedElement(new NestedList(new LinkedList<NestedElement>() {{
         add(nestedElement4);
         add(nestedElement5);
     }}));

     NestedElement nestedRange78 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement7);
         add(nestedElement8);
     }}));

     NestedElement nestedRange9 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement9);
     }}));

     NestedElement nestedRange36 = new NestedElement(new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement3);
         add(nestedRange34Empty);
         add(nestedRange45);
         add(nestedElement6);
     }}));

     NestedList testInput = new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement1);
         add(nestedElement2);
         add(nestedRange36);
         add(nestedRange78);
         add(nestedRange9);
         add(nestedElement10);
     }});

     return testInput;
 }
 
 private static NestedList getTestInput3() { 
	 //[1,2,3,4,5,6,7,8,9,10,[]]
     NestedElement nestedElement1 = new NestedElement(1);
     NestedElement nestedElement2 = new NestedElement(2);
     NestedElement nestedElement3 = new NestedElement(3);
     NestedElement nestedElement4 = new NestedElement(4);
     NestedElement nestedElement5 = new NestedElement(5);
     NestedElement nestedElement6 = new NestedElement(6);
     NestedElement nestedElement7 = new NestedElement(7);
     NestedElement nestedElement8 = new NestedElement(8);
     NestedElement nestedElement9 = new NestedElement(9);
     NestedElement nestedElement10 = new NestedElement(10);
     NestedElement nestedRangeAfter10Empty = new NestedElement(new NestedList(new LinkedList<NestedElement>() {{    	 
     }}));
     
     NestedList testInput = new NestedList(new LinkedList<NestedElement>(){{
         add(nestedElement1);
         add(nestedElement2);
         add(nestedElement3);
         add(nestedElement4);
         add(nestedElement5);
         add(nestedElement6);
         add(nestedElement7);
         add(nestedElement8);
         add(nestedElement9);
         add(nestedElement10);
         add(nestedRangeAfter10Empty);
     }});
     
     return testInput;
 }
 
 private static NestedList getTestInput4() { //[]
     NestedList testInput = new NestedList(new LinkedList<NestedElement>(){{
         
     }});
     
     return testInput;
 }
 
 private static NestedList getTestInput5() { //[]
	 NestedElement nestedEmpty = new NestedElement(new NestedList(new LinkedList<NestedElement>() {{    	 
     }}));
     NestedList testInput = new NestedList(new LinkedList<NestedElement>(){{
         add(nestedEmpty);
     }});
     
     return testInput;
 }
 static class NestedListIterator implements Iterator<Integer> {
     private NestedList nestedList;
     private List<NestedElement> list;
     private Stack<List<NestedElement>> stack = new Stack<>();

     public NestedListIterator(NestedList nestedList) {
         this.nestedList = nestedList;
     }
//*      input: [1,2,[3,[4,5],6],[],[7,8],[9],10]
     @Override
     public boolean hasNext() {
         if(this.nestedList == null)
           return false;
         else if(this.nestedList.getElementList() == null)
           return false;
         else if(this.list == null){
           this.list = this.nestedList.getElementList();
           cleaning();
         }
         
         return this.list != null;
     }
     

     @Override
     public Integer next() {
         if(this.nestedList == null)
           return null;
         else if(this.nestedList.getElementList() == null)
           return null;
         else if(this.list == null){
           this.list = this.nestedList.getElementList();              
         }         
         
         return nextHelper();
     }
     
     private Integer nextHelper() {
       cleaning();
       if(this.list == null){
         return null;
       }else if(!this.list.get(0).isList()){
         Integer result = list.remove(0).getIntElement();
         cleaning();
         return result;
       }else{
         stack.push(list);
         list = this.list.get(0).getNestedList().getElementList();
         return nextHelper();
       }
     }
     
   private void cleaning(){
     if(list.isEmpty() && !stack.isEmpty()){
       list = stack.pop();
       list.remove(0);
       cleaning();
     }else if(list.isEmpty())
    	 list = null;
     else if(list.get(0).isList()) {
    	 stack.push(list);
    	 list = list.get(0).getNestedList().getElementList();
    	 cleaning();
     }
   }
 }


 public static void main(String[] args) {
     NestedListIterator nestedListIterator = new NestedListIterator(getTestInput());
     System.out.println("Test [1,2,[3,[4,5],6],[7,8],[9],10]");
     while(nestedListIterator.hasNext()) {
         System.out.println(nestedListIterator.next());
     }
     
     System.out.println("Test [1,2,[3,[],[4,5],6],[7,8],[9],10]");
     nestedListIterator = new NestedListIterator(getTestInput2());
     while(nestedListIterator.hasNext()) {
         System.out.println(nestedListIterator.next());
     }
     
     System.out.println("Test [1,2,3,4,5,6,7,8,9,10,[]]");
     nestedListIterator = new NestedListIterator(getTestInput3());
     while(nestedListIterator.hasNext()) {
         System.out.println(nestedListIterator.next());
     }
     
     System.out.println("Test []");
     nestedListIterator = new NestedListIterator(getTestInput4());
     while(nestedListIterator.hasNext()) {
         System.out.println(nestedListIterator.next());
     }
     
     System.out.println("Test [[]]");
     nestedListIterator = new NestedListIterator(getTestInput5());
     while(nestedListIterator.hasNext()) {
         System.out.println(nestedListIterator.next());
     }
 }

}

