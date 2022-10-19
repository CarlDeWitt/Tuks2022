#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <cmath>

extern "C"
{
  struct Student
  {
    double average;
    int id;
    char pad[4];
  };

  Student *enrol(int);
  void predict(Student *, int, double);
  Student *filter(Student *, int);
  void expel(Student *);
  int getStudentSize();
  int getAverageOffset();
  int getIdOffset();
}

bool compare_float(double x, double y, double epsilon = 0.0000001f)
{
  return fabs(x - y) < epsilon;
}

int main()
{
  // Update these to alter the information displayed
  int total = 0;
  int correct = 0;
  int practicalMark = 0;
  const int count = 8;
  double marks[] = {53.33, 28.09, 78.12, 92.33, 99.999998, 45.67, 99.999999, 89.12};

  Student *students = enrol(count);

  try
  {
    for (int i = 0; i < count; i++)
    {
      students[i].average = 0.0;
      students[i].id = -1;
    }
  }
  catch (const std::exception &e)
  {

    std::cerr << "Error: " << e.what() << std::endl;
    printf("TASK 1: 0/1\n");
    printf("Practical mark: %d/5\n", practicalMark);

    return 0;
  }

  for (int i = 0; i < count; i++)
  {
    total++;
    if (students[i].average == 0.0 && students[i].id == -1)
    {
      correct++;
    }
  }

  printf("\nTASK 1 (%d/1): %d/%d allocations\n\n", correct == total, correct, total);
  practicalMark += correct == total;

  printf("Students before prediction:\n");
  for (int i = 0; i < count; i++)
  {
    printf("Student %d: %f\n", students[i].id, students[i].average);
  }

  for (int i = 0; i < count; i++)
  {
    try
    {
      predict(students, i, marks[i]);
    }
    catch (const std::exception &e)
    {
      std::cerr << "Error: " << e.what() << std::endl;
      return 0;

      printf("Task 2: 0/1\n");
      printf("Practical mark: %d/5\n", practicalMark);

      return 0;
    }
  }

  printf("\nStudents after prediction:\n");
  for (int i = 0; i < count; i++)
  {
    printf("Student %d: %f\n", students[i].id, students[i].average);
  }

  total = 0;
  correct = 0;

  for (int i = 0; i < count; i++)
  {
    total++;
    if (students[i].average == marks[i] && students[i].id == i)
    {
      correct++;
    }
  }

  printf("\nTASK 2 (%d/1): %d/%d predictions\n", correct == total, correct, total);
  practicalMark += correct == total;

  // Print the size of a student struct
  printf("\nSize of student struct in C++: %ld \n", sizeof(Student));
  printf("Size of student struct in ASM: %d \n", getStudentSize());

  // Print the offset of the average field
  printf("\nOffset of average field in C++: %ld \n", (long)&((Student *)0)->average);
  printf("Offset of average field in ASM: %d \n", getAverageOffset());

  // Print the offset of the id field
  printf("\nOffset of id field in C++: %ld \n", (long)&((Student *)0)->id);
  printf("Offset of id field in ASM: %d \n", getIdOffset());

  // Print the alignment size of a student struct
  printf("Alignment of student struct in C++: %ld \n", __alignof__(Student));
  printf("Alignment of student struct in ASM: %ld \n\n", __alignof__(students[0]));

  try
  {
    Student *filtered = filter(students, count);

    for (int i = 0; i < count; i++)
    {
      // If the filtered student matches the current student, print the student
      if (filtered->id == students[i].id)
      {
        printf("***Top student***    ID-%d     Average: %f\n", filtered->id, filtered->average);
        continue;
      }

      if (students[i].average > 50)
      {
        printf("+Graduating+         ID-%d     Average: %f\n", students[i].id, students[i].average);
        continue;
      }
      printf("-Failing-            ID-%d     for poor performance\n", students[i].id);
    }

    // If mark mode is enabled, print the mark for task 3
    // Find the index of the highest average in double marks[]
    int highestIndex = 0;
    for (int i = 1; i < count; i++)
    {
      if (marks[i] > marks[highestIndex])
      {
        highestIndex = i;
      }
    }
    printf("\nTASK 3 (%d/3): %f \n", compare_float(filtered->average, marks[highestIndex]) * 3, filtered->average);
    practicalMark += compare_float(filtered->average, marks[highestIndex]) * 3;
  }
  catch (const std::exception &e)
  {
    std::cerr << "Error: " << e.what() << std::endl;

    printf("\nTASK 3: 0/3\n");
    printf("Practical mark: %d/5", practicalMark);

    return 0;
  }

  // If mark mode is enabled, print the practical mark
  printf("\nPRACTICAL MARK: %d/5 \n", practicalMark);
  expel(students);

  return 0;
}
