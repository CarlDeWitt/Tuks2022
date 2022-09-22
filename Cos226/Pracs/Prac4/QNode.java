class QNode {
  boolean locked = false;
  QNode next = null;
  String name = Thread.currentThread().getName();
  int number = 1;
  QNode pred = null;
}