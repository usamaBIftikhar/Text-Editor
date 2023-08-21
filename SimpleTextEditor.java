package PersonalProjects;
/**
 * Implemented Simple Text Editor class with the use of Positional List ADT and an iterator
 * to loop through collection of this List ADT
 *
 * By Kingsley N. Okeke
 * Started April 1st, 2020
 *
 * public class SimpleTextEditor
 *
 * Public Methods:
 *  -SimpleTextEditor() -> Constructor
 *   Initialises the cursor object,the Linked PositionalList ADT, and the
 *   first character(cursor object) in the TextEditor as a node in the ADT
 *
 *  -insert(char c)
 *    Takes a character and inputs it just before the cursor
 *    object in the TextEditor
 *
 *   -delete()
 *      Deletes any character that appears just before the text editor
 *
 *   -left()
 *      Shifts the cursor object one step to the left each time it is called
 *
 *    -right()
 *      Shifts the cursor object one step to the right each time it is called
 *
 *
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleTextEditor {
    protected LinkedPositionalList<Character> linkedPositionalList;
    protected char cursor;
    protected Position<Character> position;

    public SimpleTextEditor() {
        cursor = '^';
        linkedPositionalList = new LinkedPositionalList<>();
        this.position = linkedPositionalList.addFirst(cursor);
    }//constructor

    /**
     * This function forms the texts in the TextEditor. It inserts characters(after the cursor)
     * into the text editor(PositionalList ADT) when called.
     *
     * It uses an enhanced for-loop to go through the iterable representation of the List ADT
     * @param c the given character to be encoded into the list
     */
    public void insert(char c){
        Iterable<Position<Character>> iterable = linkedPositionalList.positions();      // Iterable PositionalList

        for(Position<Character> p: iterable){
            if(p.equals(position)){
                linkedPositionalList.addBefore(position, c);
            }
        }//enhanced for-loop
    }

    /**
     * This function deletes any character that appears after the cursor
     *
     * Similar to insert, it uses the enhanced for loop to loop through the PositionalList ADT
     *
     * @throws NoSuchElementException Exception is made if the cursor appears at the end of the PositionalList
     */
    public void delete() throws NoSuchElementException{
        Iterable<Position<Character>> iterable = linkedPositionalList.positions();      // Iterable PositionalList
        int size = 1;
        for(Position<Character> p: iterable){
            if(p.equals(position) && size == linkedPositionalList.size()){
                throw new NoSuchElementException("Can't Delete At End");
            }
            size+=1;
        }//for loop
        Position<Character> position = linkedPositionalList.after(this.position);
        linkedPositionalList.remove(position);
    }

    /**
     * This function simply moves the cursor object a step to the left when called.
     *  Function does nothing if the cursor object appears at the beginning of our text editor.
     *
     * It does this shifting by simply swapping the character(node) before the cursor object with the
     * cursor object.
     *
     */
    public void left(){
        //does nothing if at the beginning
        if(linkedPositionalList.first().equals(position))
            return;
        //shifts cursor object to the left
        else{
            Position<Character> position = linkedPositionalList.before(this.position);
            linkedPositionalList.remove(this.position);
            this.position = linkedPositionalList.addBefore(position, cursor);
        }

    }

    /**
     * This function simply moves the cursor object a step to the right when called.
     * The function does nothing if the cursor object is at the end of the PositionalList ADT(TextEditor)
     *
     * It does this shifting by simply swapping the character(node) after the cursor object
     * with the cursor object.
     */
    public void right(){
        //does nothing if at the end
        if(linkedPositionalList.last().equals(position))
            return;

        //shifts cursor object to the right
        else{
            Position<Character> position = linkedPositionalList.after(this.position);
            linkedPositionalList.remove(this.position);
            this.position = linkedPositionalList.addAfter(position, cursor);
        }

    }


}
