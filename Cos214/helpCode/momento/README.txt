The issues that are addressed in the example are:
1) The required structure for each of the participants of the memento pattern
2) That the memento is a deep copy of the originator's state.
3) The concept of wide and narrow interfaces as well as the use of public, private and friend keywords.
4) How constructors and copy constructors are implemented
5) The use of initialiser lists in the constructors.
6) How the client should use the participants of the memento pattern.
7) The makefile entries that should show all dependencies
8) How make compiles only the class that has changed.

Note that this example does not cater for:
A) A narrow interface between the Memento the Caretaker.  The memento has a wide public interface. The interface should be reduced by making the getters private (or removing them) and giving  the Originator access to it by declaring the Originator to be a friend of the Memento.
B) A deep copy of the Originator state by the Memento. When the Memento is created it makes a shallow copy instead of a deep copy of the state.
