public class ReverseString {

  public static char[] reverseString(char arr[]) {

    int first = 0, end = arr.length - 1;
    while (first <= end) {
      char temp = arr[first];
      arr[first] = arr[end];
      arr[end] = temp;
      first++;
      end--;
    }

    return arr;
  }

  public static void main(String[] args) {

    char arr[] = { 'a', 'b', 'c', 'd', 'e' };
    char ans[] = reverseString(arr);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + "-->");

    }

    System.out.println();

  }
}
