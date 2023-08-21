
package PersonalProjects;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        SimpleTextEditor simpleTextEditor = new SimpleTextEditor();

        Iterable<Position<Character>> iterable = simpleTextEditor.linkedPositionalList.positions();    //list

        //Hey there, just testing my name!
        simpleTextEditor.insert('K');
        simpleTextEditor.insert('I');
        simpleTextEditor.insert('N');
        simpleTextEditor.insert('G');
        simpleTextEditor.insert('S');
        simpleTextEditor.insert('L');
        simpleTextEditor.insert('E');
//        simpleTextEditor.delete();
        simpleTextEditor.insert('Y');
        simpleTextEditor.left();
        simpleTextEditor.left();
        simpleTextEditor.right();
        String ret = "";
        for(Position<Character> p: iterable){
            ret+=p.getElement();
        }
        System.out.print(ret);
    }

}
