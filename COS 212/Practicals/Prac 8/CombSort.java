public class CombSort extends Sorting {
    public CombSort() {
        name = "CombSort";
    }

    @Override
    public String[] sortAcs(Vertex[] array) {
        String[] arr = vertexToString(array);
        int gap = arr.length;
        boolean swap = false;
        while (gap > 1 || swap == true) {
            swap = false;
            if (gap > 1) {
                gap = ((int) (gap / 1.3));
            }
            int i = 0;
            while (i + gap < arr.length) {
                if (arr[i].compareTo(arr[i + gap]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;
                    swap = true;
                }
                i++;
            }
            printArr(arr);
            System.out.println("Gap: " + gap);
        }
        return arr;
    }

    @Override
    public String[] sortDsc(Vertex[] array) {
            String[] arr = vertexToString(array);
            int gap = arr.length;
            boolean swap = false;

            while (gap > 1 || swap == true) {
                swap = false;
                if (gap > 1) {
                    gap = ((int) (gap / 1.3));
                }
                int i = 0;
                while (i + gap < arr.length) {
                    if (arr[i].compareTo(arr[i + gap]) < 0) {
                        String temp = arr[i];
                        arr[i] = arr[i+gap];
                        arr[i+gap] = temp;
                        swap = true;
                    }
                    i++;
                }
                printArr(arr);
                System.out.println("Gap: " + gap);
            }


            return arr;
        }

}
