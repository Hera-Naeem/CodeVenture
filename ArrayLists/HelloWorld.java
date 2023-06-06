import java.util.ArrayList;
import java.util.List;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

    class NamedArrayList<E> implements List<E>{
    private static final int DEFAULT = 10;

    private String name;
    private E[] data;
    private int next_index; // points to the first empty location in the list

    public NamedArrayList(String name) {
        this.name = name;
        this.data = (E[]) (new Object[DEFAULT]);
        this.next_index = 0;
    }

    public NamedArrayList(String name, int size) {
        this.name = name;
        this.data = (E[]) (new Object[size]);
        this.next_index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int size() {
        return next_index;
    }
    @Override
    public boolean isEmpty() {
        return next_index == 0;
    }
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i++){
            if(data[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean add(E e) {
        if(next_index == data.length) { // the list is full
            E[] new_data = (E[]) (new Object[data.length * 2]); // create new list (new_data) of double the current size
            for(int i = 0; i < data.size(); i++) { // copy all elements from the first list (data) into the new list (new_data)
                new_data[i] = data[i];
            }
            this.data = new_data; // the first list is equal to the new list
        }
        data[next_index] = e; // add the new element at the end of the lsit
        next_index++; // increment next_index
        return true;
    }
    @Override
    public boolean remove(E e) {
        for(int i = 0; i < data.length; i++){ // find the object that we want to remove (e)
            if(data[i].equals(e)){ // found e
                for(int j = i; j < data.length; j++) { // loop starts from the index where we found e
                    data[j] = data[j+1]; // move every element after e one step back
                }
                next_index--; // decrement next_index
                data[next_index] = null; // last location should be null/empty
                return true;
            }
        }
        return false;
    }
    @Override
    public E get(int index) { // return object at specified index
        // if index is not between 0 and the last used index
        if(index < 0 || index >= size()) { // size is one greater than the last index
            System.out.println("IndexOutOfBounds");
            return null;
        }
        return data[index]; // return element at index
    }
    @Override
    public E set(int index, E e) {
        // if index is not between 0 and the last used index
        if(index < 0 || index >= size()) { // size is one greater than the last index
            System.out.println("IndexOutOfBounds");
            return null;
        }
        E temp = data[index]; // store element that's about to be replaced in temp
        data[index] = e; // replace element at index with e
        return temp; // return variable that's been replaced
    }
    @Override
    public void add(int index, E element) {
        // if index is not between 0 and the last used index
        if(index < 0 || index >= size()) { // size is one greater than the last index
            System.out.println("IndexOutOfBounds");
            return null;
        }

        if(next_index == data.length) { // the list is full
            E[] new_data = (E[]) (new Object[data.length * 2]); // create new list (new_data) of double the current size
            for(int i = 0; i < data.size(); i++) { // copy all elements from the first list (data) into the new list (new_data)
                new_data[i] = data[i];
            }
            this.data = new_data; // the first list is equal to the new list
        }

        for(int i = next_index - 1; i >= index; i--) { // start loop from the last element in the list, end loop at index
            data[i+1] = data[i]; // move every element after index one step forward to empty the location at index
        }
        data[index] = element; // store element at index
        next_index++; // increment next_index
    }
    @Override
    public E remove(int index) {
        // if index is not between 0 and the last used index
        if(index < 0 || index >= size()) { // size is one greater than the last index
            System.out.println("IndexOutOfBounds");
            return null;
        }
        E temp = data[index]; // store element that we're about to remove in temp
        for(int i = index; i < data.length; i++) { // loop start from index, iterates thorugh the entire list
            data[i] = data [i+1]; // move every element after index one step back
        }
        next_index--; // decrement next_index
        data[next_index] = null; // last location should be null/empty
        return temp;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name); // MyList
        sb.append("["); // MyList[
        for(int i = 0; i < size()-1; i++) { // appends all elements except the last one
            sb.append(this.data[i]); // 1st: MyList[a
            sb.append(","); // 1st: MyList[a,
        }
        if(next_index != 0){
            // append last element of list to the string
            sb.append(this.data[next_index-1]); // MyList[a,b,c
        }
        sb.append("]"); // MyList[a,b,c]
        return sb.toString();
    }

}
